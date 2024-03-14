CREATE TABLE referral_link_event
(
    id              UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    event           VARCHAR(255),   --событие
    ref_code        UUID,           --идентификатор ссылки
    client          VARCHAR(255),   --опциональный, идентификатор клиента (БИН/ИИН)
    sib_user_id     UUID,           --опциональный, идентификатор пользователя
    action          VARCHAR(255),   --тип действия
    action_id       UUID,           --опциональный, идентификатор действия/запущенного процесса
    result          VARCHAR(255)    --опциональный, результат выполнения, произвольный текст
);