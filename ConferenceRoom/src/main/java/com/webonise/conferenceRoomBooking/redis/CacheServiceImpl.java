package com.webonise.conferenceRoomBooking.redis;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import com.webonise.conferenceRoomBooking.exception.CacheServiceException;
import com.webonise.conferenceRoomBooking.redis.cache.Cachable;

/**
 * This class components is the implementation of {@link CacheService},
 * providing the basic CURD operations over Redis.
 * 
 * @author Pradeep
 *
 */
@Component
public class CacheServiceImpl implements CacheService {
    private static final Logger LOG = LoggerFactory.getLogger(CacheServiceImpl.class);

    @Autowired
    private RedisTemplate<String, Cachable> redisTemplate;

    @Override
    public void save(final Cachable cachable) throws CacheServiceException {
        LOG.debug("Saving object for key: {}", cachable.getKey());
        redisTemplate.opsForHash().put(cachable.getObjectKey(), cachable.getKey(), cachable);
    }

    @Override
    public void delete(final Cachable cachable) throws CacheServiceException {
        LOG.debug("Deleting object for key: {}", cachable.getKey());
        redisTemplate.opsForHash().delete(cachable.getObjectKey(), cachable.getKey());
    }

    @Override
    public void update(final Cachable cachable) throws CacheServiceException {
        LOG.debug("Updating object for key: {}", cachable.getKey());

    }

    @Override
    public Cachable read(final String hashKey, final String key) throws CacheServiceException {
        LOG.debug("Reading key: {} from hashKey: {}", key, hashKey);
        return (Cachable) redisTemplate.opsForHash().get(hashKey, key);
    }

    @Override
    public Map<Object, Object> readAllHash(final String hashKey) throws CacheServiceException {
        LOG.debug("Reading all object for hashKey: {}", hashKey);
        return (Map<Object, Object>) redisTemplate.opsForHash().entries(hashKey);
    }

    @Override
    public void deleteAll(List<Cachable> cachableList) throws CacheServiceException {
        LOG.debug("Deleting object list {}", cachableList);
        for ( Cachable cachable : cachableList ) {
            redisTemplate.opsForHash().delete(cachable.getObjectKey(), cachable.getKey());
        }
    }

    @Override
    public void deleteAll(String hashKey) throws CacheServiceException {
        redisTemplate.delete(hashKey);
        
        
        
        
    }

}
