package com.wechat.util;

public class XStreamUtil {

	@SuppressWarnings("unchecked")
	public static <T> T toObject(String xmlStr, Class<T> cls) {
		CDataXStream xstream = new CDataXStream();
		xstream.autodetectAnnotations(true);
		xstream.processAnnotations(cls);
		xstream.ignoreUnknownElements();
		T obj = (T) xstream.fromXML(xmlStr);
		return obj;
	}

	public static String toXml(Object obj) {
		CDataXStream xstream = new CDataXStream();
		xstream.autodetectAnnotations(true);
		xstream.processAnnotations(obj.getClass());
		return xstream.toXML(obj);
	}

}
