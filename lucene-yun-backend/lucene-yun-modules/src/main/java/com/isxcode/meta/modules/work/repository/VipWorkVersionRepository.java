package com.isxcode.meta.modules.work.repository;

import com.isxcode.meta.modules.work.entity.VipWorkVersionEntity;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@CacheConfig(cacheNames = {"sy_work"})
public interface VipWorkVersionRepository extends JpaRepository<VipWorkVersionEntity, String> {
}
