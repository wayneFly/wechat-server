package com.wechat.util;

import java.io.Writer;
import java.util.regex.Pattern;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;

/**
 * 
 * 扩展stream使其支持cdata
 */
public class CDataXStream extends XStream {

	public HierarchicalStreamWriter createWriter(Writer out) {
		return new PrettyPrintWriter(out) {
			boolean cdata = false;

			public void startNode(String name, @SuppressWarnings("rawtypes") Class clazz) {
				if (!name.equals("xml")) {
					char[] arr = name.toCharArray();
					if (arr[0] >= 'a' && arr[0] <= 'z') {
						arr[0] = (char) ((int) arr[0] - 32);
					}
					name = new String(arr);
				}

				super.startNode(name, clazz);

			}

			@Override
			public void setValue(String text) {

				if (text != null && !"".equals(text)) {
					// 浮点型判断
					Pattern patternInt = Pattern.compile("[0-9]*(\\.?)[0-9]*");
					// 整型判断
					Pattern patternFloat = Pattern.compile("[0-9]+");
					// 如果是整数或浮点数 就不要加[CDATA[]了
					if (patternInt.matcher(text).matches() || patternFloat.matcher(text).matches()) {
						cdata = false;
					} else {
						cdata = true;
					}
				}
				super.setValue(text);
			}

			protected void writeText(QuickWriter writer, String text) {
				if (cdata) {
					writer.write("<![CDATA[");
					writer.write(text);
					writer.write("]]>");
				} else {
					writer.write(text);
				}
			}
		};
	}
}
