package com.zhaozheng.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.serializer.JSONLibDataFormatSerializer;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;
import java.util.*;

public class FastJsonUtil {
  private static final SerializeConfig config;

  static {
    config = new SerializeConfig();
    // 使用和json-lib兼容的日期输出格式
    config.put(Date.class, new JSONLibDataFormatSerializer());
    // 使用和json-lib兼容的日期输出格式
    config.put(java.sql.Date.class, new JSONLibDataFormatSerializer());
  }

  // 输出json字符串的属性要求，如果方法中未加入此属性则json格式按照默认的格式输出
  private static final SerializerFeature[] features = {
      // 输出空置字段
      SerializerFeature.WriteMapNullValue,

      // list字段如果为null，输出为[]，而不是null
      SerializerFeature.WriteNullListAsEmpty,

      // 数值字段如果为null，输出为0，而不是null
      SerializerFeature.WriteNullNumberAsZero,

      // Boolean字段如果为null，输出为false，而不是null
      SerializerFeature.WriteNullBooleanAsFalse,

      // 字符类型字段如果为null，输出为""，而不是null
      SerializerFeature.WriteNullStringAsEmpty,

      // 禁止循环引用
      SerializerFeature.DisableCircularReferenceDetect,

  };

  // object转json，具备日期兼容，具备输出json字符串的属性要求
  public static String objToJSON(Object obj) {
    return JSON.toJSONString(obj, config, features);
  }

  // object转json不带Features
  public static String objToJSONNoFeatures(Object obj) {
    // JSON.toJSONString则是将对象转化为Json字符串。
    return JSON.toJSONString(obj, config);
  }

  // json转object
  public static Object strToBean(String strJson) {
    // 把JSON文本parse为JSONObject或者JSONArray
    return JSON.parse(strJson);
  }

  // json转泛类
  // 按照指定的字节码返回相应对象的的反序列化方法
  public static <T> T strToBean(String strJson, Class<T> clazz) {
    // JSON.parseObject，是将Json字符串转化为相应的对象
    return JSON.parseObject(strJson, clazz);
  }

  // 对进行泛型的反序列化，使用TypeReference可以明确的指定反序列化的类型。
  public static <T> T strToBean(String strJson, TypeReference<T> typeReference) {
    return JSONObject.parseObject(strJson, typeReference);
  }

  public static Object convertJsonToObject(String strJson, Class<?> clazz) {
    return JSONObject.parseObject(strJson, clazz);
  }

  // json转object数组
  public static <T> Object[] toArray(String strJson) {
    return toArray(strJson, null);
  }

  // json转泛数组
  public static <T> Object[] toArray(String strJson, Class<T> clazz) {
    return JSON.parseArray(strJson, clazz).toArray();
  }

  // json转list
  public static <T> List<T> toList(String strJson, Class<T> clazz) {
    return JSON.parseArray(strJson, clazz);
  }

  // 字符串转map
  // 解析时增加参数(Feature.OrderedField),可保持属性在解析前和解析后顺序一致。
  public static <K, V> Map<K, V> toMap(String strJson) {
    Map<K, V> m = (Map<K, V>) JSONObject.parseObject(strJson, Feature.OrderedField);
    return m;
  }

  // 字符串转hashmap
  // LinkedHashMap继承自 HashMap,在HashMap基础上,通过维护一条双向链表,
  // 解决了HashMap不能随时保持  遍历顺序  和  插入顺序  一致的问题。
  public static HashMap<String, Object> toHashMap(String strJson) {
    return JSONObject.parseObject(strJson, LinkedHashMap.class);
  }

  // map 转json串
  // features 中配置了禁止循环检测
  // SerializerFeature.DisableCircularReferenceDetect,
  public static <K, V> String mapToString(Map<K, V> map) {
    String s = JSONObject.toJSONString(map, features);
    return s;
  }

  // 在json串找键对应的值
  public static String getString(String strJson, String key) {
    return JSON.parseObject(strJson).getString(key);
  }
}

/*
  FastJson常用的序列化和反序列化操作:
  // 把JSON文本parse为JSONObject或者JSONArray
  public static final Object parse(String text);

  // 把JSON文本parse成JSONObject
  public static final JSONObject parseObject(String text);

  // 把JSON文本parse为JavaBean
  public static final  T parseObject(String text, Class clazz);

  // 把JSON文本parse成JSONArray
  public static final JSONArray parseArray(String text);

  //把JSON文本parse成JavaBean集合
  public static final  List parseArray(String text, Class clazz);

  // 将JavaBean序列化为JSON文本
  public static final String toJSONString(Object object);

  // 将JavaBean序列化为带格式的JSON文本
  public static final String toJSONString(Object object, boolean prettyFormat);

  // 将JavaBean转换为JSONObject或者JSONArray
  public static final Object toJSON(Object javaObject);

  1. JSON.parseObject 和 JSON.toJSONString 区别
    ①. 在JSON.parseObject 的时候，会去填充名称相同的属性。对于Json字符串中没有，而model类有的属性(birthday)，会为null；
    ②. 在JSON.toJSONString的时候，对于model类没有的属性，而Json字符串有的属性(telephone)，不做任何处理。

  2. JSON.parseObject(String strJson)与JSONObject.parseObject(String strJson)的区别
     JSON是一个抽象类，JSON中有一个静态方法parseObject(tring text)，将strJson解析为一个JSONObject对象并返回；
     JSONObject是一个继承自JSON的类，当调用JSONObject.parseObject(strJson)时，会直接调用父类的parseObject(strJson)。
     所以两者没什么区别，两者调的是同一个方法。

  3. TypeReference方式和class类方式解析JSON数据的区别
     TypeReference 可以明确的指定反序列化的类型，能够清晰，明了解析多级泛型。
     JSON.parseObject(String strJson, Class<T> clazz) 按照指定的字节码返回相应对象的的反序列化方法
     举个例子就知道区别:
     public class Result<T> {
       private int ret;
       private String msg;
       private T data;
     }

     public class Item {
       private String name;
       private String value;
    }

    Json数据:
    {
	    "data":{
		    "name":"username",
		    "value":"root"
	    },
	    "msg":"Success",
	    "ret":0
    }
    情况1:
    JSONObject.parseObject(json, Result<Item>.class);
    编译器就报错了Cannot select parameterized type

    情况2:
    JSONObject.parseObject(json, Result.class);
    执行没问题。但是没有Item类型信息，fastjson不可能知道该把data转为Item类型，result.getData().getClass()结果是com.alibaba.fastjson.JSONObject，也算是个妥善处理吧。

    情况3:
    JSONObject.parseObject(json, new TypeReference<Result<Item>>(){});
    "完美"解决！

  4.Object 和 泛型T， 通配符 ? 的区别?

    Object是所有类的根类，是具体的一个类，使用的时候可能需要类型强制转换的，
    但是用通配符 ?、T 、K 、V、 E 等这些的话，在实际用之前类型就已经确定了，不需要强制转换。

    方法能知道参数类型(父类)，就用 T 行了;
    如果完全不知道的就用 ? 。
    用 T 得到的对象就不需要类型转换了，而用 ? 得到的对象就必需用强转了！

    T: 是固定的一种泛型,固定的泛型指类型是固定的.
       比如: Interge,String就是<T extends Collection>

    ?: 只要是Object类的子类都可以，换言之，任何类都可以，因为Object是所有类的根基类.
       比如: <? extends Collection> 这里 ? 代表一个未知的类型，
       但是，这个未知的类型实际上是Collection的一个子类，Collection是这个通配符的上限。

*/
