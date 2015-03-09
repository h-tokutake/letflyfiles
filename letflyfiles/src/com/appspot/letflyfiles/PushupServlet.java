package com.appspot.letflyfiles;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.blobstore.BlobstoreService;
import com.google.appengine.api.blobstore.BlobstoreServiceFactory;

@SuppressWarnings("serial")
public class PushupServlet extends BaseServlet {
	private BlobstoreService bss = BlobstoreServiceFactory.getBlobstoreService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String uploadUrl = bss.createUploadUrl("/list");
		req.setAttribute("uploadUrl", uploadUrl);
		dispatchScreen(req, resp, "/WEB-INF/pushup.jsp");
	}
}
