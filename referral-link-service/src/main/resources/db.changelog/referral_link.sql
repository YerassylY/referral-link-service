CREATE TABLE referral_link
(
    id           UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    type         VARCHAR(255),
    track_code   VARCHAR(255),
    client       VARCHAR(255),
    ttl          VARCHAR(255),
    action_limit INT,
    link         VARCHAR(255) NOT NULL,
    expired_at   TIMESTAMP
);