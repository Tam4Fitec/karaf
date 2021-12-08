package com.leguide.backoffice.karaf.bundle.offer.datacollection.beans;

import com.leguide.backoffice.karaf.bundle.pixeltracking.leguide.PixelBean;
import com.leguide.backoffice.karaf.bundle.pixeltracking.leguide.PixelHeader;
import com.leguide.backoffice.karaf.bundle.pixeltracking.leguide.PixelHeaderList;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.List;

/**
 * Redis Bean
 */
public class RedisBean {
	private static final Logger LOG = LoggerFactory.getLogger(RedisBean.class);

	@Value("${redis.key.ttl:500}")
	private int timeToLive;
	
    @Autowired
    private JedisPool redisMasterPool;


    public void incrementOfferHits(PixelBean pixel) {

    	String key = createKey(pixel);

    	Jedis redis = null;
    	try {
            redis = redisMasterPool.getResource();

            //Pipeline p = redis.pipelined();
            //Transaction t = redis.multi();
            List<String> offerIds = pixel.getHeaderValueList(PixelHeaderList.OFFER_IDS);

            if (offerIds != null)
                for (String offerId : offerIds)
                    if (!offerId.equals(""))
                        redis.zincrby(key, 1, offerId);

            String offerId = pixel.getHeaderValue(PixelHeader.OFFER_ID);

            if (offerId != null && !offerId.equals(""))
                redis.zincrby(key, 1, offerId);



            redis.expire(key, timeToLive);
            //p.sync();
            //t.exec();
        } catch (Exception e) {
            // catch exception thrown by redis.expire
    	} finally {
    		redisMasterPool.returnResource(redis);
 		}
    }

     
	private String createKey(PixelBean pixel) {
		StringBuilder keySb = new StringBuilder();
        keySb.append("offer:visit:");
        keySb.append("s:");
        keySb.append(pixel.getHeaderValue(PixelHeader.SITE)).append(":");
        keySb.append("date:");
        keySb.append(DateTime.now().toString("yyyyMMdd"));
		return keySb.toString();
	}
	
	

}
