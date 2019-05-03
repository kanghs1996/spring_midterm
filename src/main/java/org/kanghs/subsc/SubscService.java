package org.kanghs.subsc;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

@Service
public class SubscService {
	@Autowired
	SubscDao subscDao;
	
	Logger logger = LogManager.getLogger();
	
	//구독/구독해제
	public void subscribe() {
		Subsc subsc = new Subsc();
		subsc.setUserId("1");
		subsc.setName("강현수");
		subsc.setChannelId("7");
		subsc.setTitle("김어준의 뉴스공장");
		
		try {
			subscDao.addSubsc(subsc);
			logger.info("구독했습니다.");
		}catch(DuplicateKeyException e) {
			subscDao.deleteSubsc(subsc.getUserId(), subsc.getChannelId());
			logger.info("구독해제했습니다.");
		}
	}
	
	public void list() {
		List<Subsc> subscList = subscDao.listSubsc("1");
		logger.info(subscList);
	}
}
