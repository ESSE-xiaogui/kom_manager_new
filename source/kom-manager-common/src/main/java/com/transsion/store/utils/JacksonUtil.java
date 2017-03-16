package com.transsion.store.utils;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class JacksonUtil {

	private static final Logger logger = LoggerFactory.getLogger(JacksonUtil.class);

	private static ObjectMapper mapper;

	static {
		mapper = new ObjectMapper();
		mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
	}

	public static String toJSON(Object o) {
		Writer strWriter = new StringWriter();
		try {
			mapper.writeValue(strWriter, o);
		} catch (IOException e) {
			logger.error(e.getMessage(), e);
		}
		return strWriter.toString();
	}

	public static <E> E fromJSON(String json, Class<E> t) {
		try {
			return (E) mapper.readValue(json, t);
		} catch (IOException e) {
			logger.error(e.getMessage(), e);
		}
		return null;
	}

}
