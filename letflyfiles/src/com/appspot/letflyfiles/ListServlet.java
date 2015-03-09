package com.appspot.letflyfiles;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.blobstore.BlobInfo;
import com.google.appengine.api.blobstore.BlobInfoFactory;
import com.google.appengine.api.blobstore.BlobstoreService;
import com.google.appengine.api.blobstore.BlobstoreServiceFactory;

public class ListServlet extends BaseServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		BlobInfoFactory bif = new BlobInfoFactory();
		Iterator<BlobInfo> iter = bif.queryBlobInfos();

		List<String> fileNameList = new ArrayList<String>();
		List<String> contentTypeList = new ArrayList<String>();
		List<String> creationList = new ArrayList<String>();
		List<String> sizeList = new ArrayList<String>();
		List<String> blobKeyList = new ArrayList<String>();
		while(iter.hasNext()){
			BlobInfo blobInfo = iter.next();
			if(blobInfo.getSize() == 0){
				BlobstoreService bss = BlobstoreServiceFactory.getBlobstoreService();
				bss.delete(blobInfo.getBlobKey());
				continue;
			}
			fileNameList.add(blobInfo.getFilename());
			contentTypeList.add(blobInfo.getContentType());
			creationList.add(blobInfo.getCreation().toString());
			sizeList.add(String.valueOf(blobInfo.getSize()));
			blobKeyList.add(blobInfo.getBlobKey().getKeyString());
		}
		req.setAttribute("filename_list", fileNameList);
		req.setAttribute("contentType_list", contentTypeList);
		req.setAttribute("creation_list", creationList);
		req.setAttribute("size_list", sizeList);
		req.setAttribute("blobKey_list", blobKeyList);
		dispatchScreen(req, resp, "/WEB-INF/list.jsp");
	}
}
