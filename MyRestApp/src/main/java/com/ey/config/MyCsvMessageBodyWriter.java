package com.ey.config;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;

import com.ey.entity.Trade;

@Produces("text/csv")
@Provider
public class MyCsvMessageBodyWriter implements MessageBodyWriter<Trade> {

	@Override
	public boolean isWriteable(Class<?> arg0, Type type, Annotation[] arg2, MediaType arg3) {
		return type == Trade.class;
	}

	@Override
	public void writeTo(Trade trade, Class<?> arg1, Type arg2, Annotation[] arg3, MediaType arg4,
			MultivaluedMap<String, Object> arg5, OutputStream out) throws IOException, WebApplicationException {
		
		//reflection api
		//opencsv or apache poi
		PrintWriter pw = new PrintWriter(out);
		pw.write(trade.getTradeId()+","+trade.getRegion()+","+trade.getAmount()+","+trade.getDate());
		pw.close();
	}
	

}
