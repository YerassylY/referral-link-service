package kz.jysan.business.repository;

import kz.jysan.business.entity.ReferralLink;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.UUID;

@Repository
public interface ReferralLinkRepository extends CrudRepository<ReferralLink, UUID> {

    @Modifying
    @Query("insert into referral_link (id, type, track_code, client, ttl, action_limit, link, expired_at) " +
            "values (:id, :type, :trackCode, :client, :ttl, :actionLimit, :link, :expiredAt) " +
            "on conflict do nothing")
    void insert(@Param("id") UUID id,
                @Param("type") String type,
                @Param("trackCode") String trackCode,
                @Param("client") String client,
                @Param("ttl") String ttl,
                @Param("actionLimit") Integer actionLimit,
                @Param("link") String link,
                @Param("expiredAt") LocalDateTime expiredAt);
}
