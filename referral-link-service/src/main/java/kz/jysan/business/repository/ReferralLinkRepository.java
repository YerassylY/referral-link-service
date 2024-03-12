package kz.jysan.business.repository;

import kz.jysan.business.entity.ReferralLink;
import kz.jysan.business.entity.ReferralLinkType;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
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

    @Query("select r.* from referral_link r where r.id = :refId")
    Optional<ReferralLink> getReferralLink(@Param("refId") UUID refId);

    @Query("select rt.* from referral_link_type rt")
    List<ReferralLinkType> getReferralLinkTypes();

    @Query("select rt.* from referral_link_type rt where rt.code = :code")
    ReferralLinkType getReferralLinkType(@Param("code") String code);

    @Modifying
    @Query("insert into referral_link_type (code, name, url_base, actual) " +
            "values (:code, :name, :urlBase, :actual) ")
    void addReferralLinkType(@Param("code") String code,
                             @Param("name") String name,
                             @Param("urlBase") String urlBase,
                             @Param("actual") Boolean actual);

    @Modifying
    @Query("update referral_link_type set actual = :value where code = :code")
    void changeReferralLinkTypeState(@Param("code") String code,
                                    @Param("value") Boolean actual);
}
