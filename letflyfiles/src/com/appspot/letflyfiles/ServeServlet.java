package com.appspot.letflyfiles;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.blobstore.BlobKey;
import com.google.appengine.api.blobstore.BlobstoreService;
import com.google.appengine.api.blobstore.BlobstoreServiceFactory;

public class ServeServlet extends BaseServlet {
	private BlobstoreService bss = BlobstoreServiceFactory.getBlobstoreService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String blobkeyString = req.getParameter("blobKey");
		if( blobkeyString == null || blobkeyString.isEmpty() ) {
			resp.sendRedirect("/login");
			return;
		}
		BlobKey blobKey = new BlobKey(blobkeyString);
		if (blobKey != null) {
			bss.serve(blobKey, resp);
		}
	}
}
