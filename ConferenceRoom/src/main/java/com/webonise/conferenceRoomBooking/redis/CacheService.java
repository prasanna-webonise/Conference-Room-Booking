package com.webonise.conferenceRoomBooking.redis;

import java.util.List;
import java.util.Map;

import com.webonise.conferenceRoomBooking.exception.CacheServiceException;
import com.webonise.conferenceRoomBooking.redis.cache.Cachable;

/**
 * This interface is having the collection of methods for basic CURD operations over Redis.
 * 
 * @author Pradeep
 *
 */
public interface CacheService {
    void save(Cachable cachable) throws CacheServiceException;

    void delete(Cachable cachable) throws CacheServiceException;

    void update(Cachable cachable) throws CacheServiceException;

    Cachable read(String hashKey, String key) throws CacheServiceException;

    Map<Object, Object> readAllHash(String hashKey) throws CacheServiceException;

    void deleteAll(List<Cachable> cachable) throws CacheServiceException;

    void deleteAll(String hashKey) throws CacheServiceException;
}
