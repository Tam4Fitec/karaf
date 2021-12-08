-- brands --
INSERT INTO brands (__id, name, name_normalized, name_seo, blacklisted_seo, blacklisted_sem, activation_date) VALUES (1, 'brand_1', 'brand_1', 'brand_1_seo', 0, 0, '2012-01-01');
INSERT INTO brands (__id, name, name_normalized, name_seo, blacklisted_seo, blacklisted_sem, activation_date) VALUES (4, 'brand_2', 'brand_2', 'brand_2_seo', 0, 0, '2012-01-01');
INSERT INTO brands (__id, name, name_normalized, name_seo, blacklisted_seo, blacklisted_sem, activation_date) VALUES (5, 'brand_3', 'brand_3', 'brand_3_seo', 0, 0, '2012-01-01');

-- brands_aliases --
INSERT INTO brands_aliases (__id, name, name_normalized, brands_id, activation_date) VALUES (1, 'alias_1', 'normalized_alias_1', 1, '2012-01-01');
INSERT INTO brands_aliases (__id, name, name_normalized, brands_id, activation_date) VALUES (2, 'alias_1.1', 'normalized_alias_1.1', 1, '2012-01-01');

