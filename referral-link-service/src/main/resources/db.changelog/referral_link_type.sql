CREATE TABLE referral_link_type
(
    code         VARCHAR(255) PRIMARY KEY,
    name         VARCHAR(255),
    url_base     VARCHAR(255),
    actual       BOOLEAN
);