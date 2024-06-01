INSERT INTO banking_user (id, email, first_name, identification_number, last_name)
VALUES (gen_random_uuid (), 'sam@gmail.com', 'Sam', '808829932V', 'Silva');
INSERT INTO banking_user (id, email, first_name, identification_number, last_name)
VALUES (gen_random_uuid(), 'guru@gmail.com', 'Guru', '901830556V', 'Darmaraj');
INSERT INTO banking_user (id, email, first_name, identification_number, last_name)
VALUES (gen_random_uuid(), 'ragu@gmail.com', 'Ragu', '348829932V', 'Sivaraj');
INSERT INTO banking_user (id, email, first_name, identification_number, last_name)
VALUES (gen_random_uuid(), 'randor@gmail.com', 'Randor', '842829932V', 'Manoon');

INSERT INTO banking_account(actual_balance, available_balance, banking_number, account_status, account_type, user_id,id)
VALUES (100000.00, 100000.00, 100015003000, 'ACTIVE', 'SAVINGS_ACCOUNT', '5dbb00bb-5f39-4ec3-b3cf-060d782f55d4',gen_random_uuid()),
       (100000.00, 100000.00, 100015003001, 'ACTIVE', 'SAVINGS_ACCOUNT','5dbb00bb-5f39-4ec3-b3cf-060d782f55d4', gen_random_uuid()),
       (100000.00, 100000.00, 100015003002, 'ACTIVE', 'SAVINGS_ACCOUNT', '5dbb00bb-5f39-4ec3-b3cf-060d782f55d4',gen_random_uuid()),
       (12000.00, 12000.00, 100015003003, 'ACTIVE', 'SAVINGS_ACCOUNT', '6cec7617-bc65-488a-8b9d-64a8ebfa8143',gen_random_uuid()),
       (12000.00, 12000.00, 100015003004, 'ACTIVE', 'SAVINGS_ACCOUNT', '6cec7617-bc65-488a-8b9d-64a8ebfa8143',gen_random_uuid()),
       (12000.00, 12000.00, 100015003005, 'ACTIVE', 'SAVINGS_ACCOUNT', '935f6257-2383-4e40-a833-45d36de5ddc0',gen_random_uuid()),
       (290000.00, 290000.00, 100015003006, 'ACTIVE', 'SAVINGS_ACCOUNT','6cec7617-bc65-488a-8b9d-64a8ebfa8143',gen_random_uuid()),
       (290000.00, 290000.00, 100015003007, 'ACTIVE', 'SAVINGS_ACCOUNT', '5dbb00bb-5f39-4ec3-b3cf-060d782f55d4',gen_random_uuid()),
       (290000.00, 290000.00, 100015003008, 'ACTIVE', 'SAVINGS_ACCOUNT', '935f6257-2383-4e40-a833-45d36de5ddc0',gen_random_uuid()),
       (365023.00, 365023.00, 100015003009, 'ACTIVE', 'SAVINGS_ACCOUNT', '8fe50dba-85ce-47dd-835f-12bd7e7d13c5',gen_random_uuid()),
       (365023.00, 365023.00, 100015003010, 'ACTIVE', 'SAVINGS_ACCOUNT', '935f6257-2383-4e40-a833-45d36de5ddc0',gen_random_uuid()),
       (365023.00, 89456.00, 100015003011, 'ACTIVE', 'SAVINGS_ACCOUNT', '8fe50dba-85ce-47dd-835f-12bd7e7d13c5',gen_random_uuid()),
       (89456.00, 89456.00, 100015003012, 'ACTIVE', 'SAVINGS_ACCOUNT', '6cec7617-bc65-488a-8b9d-64a8ebfa8143',gen_random_uuid()),
       (889000.33, 889000.33, 100015003013, 'ACTIVE', 'SAVINGS_ACCOUNT', '935f6257-2383-4e40-a833-45d36de5ddc0',gen_random_uuid());


INSERT INTO banking_utility_account (id,number, provider_name)
VALUES (gen_random_uuid(),'8203232565', 'VODAFONE');
INSERT INTO banking_utility_account (id,number, provider_name)
VALUES (gen_random_uuid(),'5464546545', 'VERIZON');
INSERT INTO banking_utility_account (id,number, provider_name)
VALUES (gen_random_uuid(),'6546456464', 'SINGTEL');
INSERT INTO banking_utility_account (id,number, provider_name)
VALUES (gen_random_uuid(),'7889987999', 'HUTCH');
INSERT INTO banking_utility_account (id,number, provider_name)
VALUES (gen_random_uuid(),'2132123132', 'AIRTEL');
INSERT INTO banking_utility_account (id,number, provider_name)
VALUES (gen_random_uuid(),'61645564646', 'GIO');