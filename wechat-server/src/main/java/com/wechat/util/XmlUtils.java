package com.wechat.util;

import com.thoughtworks.xstream.XStream;

/**
 * @项目名称：chnsys-plugin-report
 * @类名称：XmlUtils
 * @类描述：
 * @version 1.0.0
 */
public class XmlUtils {


	/**
	 * obj转换成XML
	 * 
	 * @Title: toXml
	 * @Description: TODO()
	 * @param obj
	 * @return
	 * @author liuyanfei
	 * @date 2015年9月9日 上午11:45:56
	 */
	public static String toXml(Object obj) {
		XStream xstream = new XStream();
		xstream.autodetectAnnotations(true);
		xstream.processAnnotations(obj.getClass());
		return xstream.toXML(obj);
	}

	/**
	 * xml转换成obj
	 * 
	 * @Title: toObject
	 * @Description: TODO()
	 * @param xmlStr
	 * @param cls
	 * @return
	 * @author liuyanfei
	 * @date 2015年9月9日 上午11:46:10
	 */
	@SuppressWarnings("unchecked")
	public static <T> T toObject(String xmlStr, Class<T> cls) {
		XStream xstream = new XStream();
		xstream.autodetectAnnotations(true);
		xstream.processAnnotations(cls);
		xstream.ignoreUnknownElements();
		T obj = (T) xstream.fromXML(xmlStr);
		return obj;
	}

}
