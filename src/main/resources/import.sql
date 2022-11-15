-- the order of values is related to the name of field.
-- Updating is necessary, if the name is changed



INSERT INTO "public"."order_main" VALUES (2147483643, '3100 Western Road A', 'customer2@email.com', 'customer2', '2343456', '2018-03-15 12:52:20.439', 100.00, 0, '2018-03-15 12:52:20.439');
INSERT INTO "public"."order_main" VALUES (2147483645, '3100 Western Road A', 'customer2@email.com', 'customer2', '2343456', '2018-03-15 12:52:29.007', 4.00, 0, '2018-03-15 12:52:29.007');
INSERT INTO "public"."order_main" VALUES (2147483641, '3100 Western Road A', 'customer2@email.com', 'customer2', '2343456', '2018-03-15 12:52:07.428', 180.00, 2, '2018-03-15 12:52:53.664');
INSERT INTO "public"."order_main" VALUES (2147483647, '3100 Western Road A', 'customer2@email.com', 'customer2', '2343456', '2018-03-15 12:52:35.289', 2.00, 2, '2018-03-15 12:52:55.919');
INSERT INTO "public"."order_main" VALUES (2147483649, '3100 Western Road A', 'customer2@email.com', 'customer2', '2343456', '2018-03-15 12:58:23.824', 150.00, 0, '2018-03-15 12:58:23.824');
INSERT INTO "public"."order_main" VALUES (2147483642, '3200 West Road', 'customer1@email.com', 'customer1', '123456789', '2018-03-15 13:01:21.135', 4.00, 2, '2018-03-15 13:02:09.023');
INSERT INTO "public"."order_main" VALUES (2147483640, '3200 West Road', 'customer1@email.com', 'customer1', '123456789', '2018-03-15 13:01:16.271', 20.00, 2, '2018-03-15 13:02:52.067');
INSERT INTO "public"."order_main" VALUES (2147483648, '3200 West Road', 'customer1@email.com', 'customer1', '123456789', '2018-03-15 13:01:06.943', 134.00, 1, '2018-03-15 13:02:56.498');

-- ----------------------------
-- Table structure for product_category

-- ----------------------------
-- Records of product_category
-- ----------------------------
INSERT INTO "public"."product_category" VALUES (2147483641, 'White & Floral Teas', 0, '2018-03-09 23:03:26', '2018-03-10 00:15:27');
INSERT INTO "public"."product_category" VALUES (2147483642, 'Oolong Tea', 2, '2018-03-10 00:15:02', '2018-03-10 00:15:21');
INSERT INTO "public"."product_category" VALUES (2147483644, 'Green Tea', 3, '2018-03-10 01:01:09', '2018-03-10 01:01:09');
INSERT INTO "public"."product_category" VALUES (2147483645, 'Black Tea', 1, '2018-03-10 00:26:05', '2018-03-10 00:26:05');


-- ----------------------------
-- Records of product_in_order
-- ----------------------------

INSERT INTO "public"."product_in_order" VALUES (2147483642, 0,1,'Produced in Fujian Fu Ding, White Peony is a mildly fermented tea that is very lightly processed and made from tender shoots of the tea leaves to make a premium grade cup of tea. It has a pleasantly sweet taste that is similar to that of fruit and honey.', 'https://safespaces.sgp1.digitaloceanspaces.com/White-Peony.jpg', 'B0001', 'White Peony 80g', 60.00, 96,NULL, 2147483641);
INSERT INTO "public"."product_in_order" VALUES (2147483644, 0,1, 'With hints of floral and dried longan notes, this Pu Er is harvested at Banpen Village with an altitude of 1760 meters. The brownish red brew is slightly in the bitter side and suits the palates of tea enthusiast that prefers a strong tasting tea.', 'https://safespaces.sgp1.digitaloceanspaces.com/Ban-Pen-Pu-Er-2019.jpg', 'B0002', 'Ban Pen Ancient Tea Tree 2019 50g', 78.00, 0,NULL, 2147483643);


-- ----------------------------
-- Records of product_info
-- ----------------------------
INSERT INTO "public"."product_info" VALUES ('B0003', 0, '2018-03-10 10:37:39', 'A blend of superior grade Jasmine flowers, Oolong Tea and Oolong pekoes makes for this high-grade Silver Hair Jasmine tea. It is best sipped on slowly to ease stress, with a distinctively smooth finish and a rich aroma.', 'https://safespaces.sgp1.digitaloceanspaces.com/Jasmine-Tea.jpg', 'Silver Hair Jasmine 50g', 49.00, 0, 23, '2018-03-10 19:42:02');
INSERT INTO "public"."product_info" VALUES ('C0004', 2, '2018-03-10 12:12:46', 'The Golden Cassia was discovered in Anxi village, Fujian, China, sometime between 1850 and 1860. This Chinese tea and its variants are made from oolong tea shoots, which produces a golden yellow colour during its brew, hence its name. An alternative name for the Golden Cassia used in Zhaoan China is Eight Immortals Tea.', 'https://safespaces.sgp1.digitaloceanspaces.com/Golden-Cassia.jpg', 'Golden Cassia 50g', 22.00, 1, 0, '2018-03-10 12:12:46');
INSERT INTO "public"."product_info" VALUES ('D0001', 3, '2018-03-10 06:51:03', 'Gyokuro is regarded as the best among Japanese tea in terms of quality, aroma and taste. Gokuro Kozan is made of the first flush and elaborately processed with the traditional techniques. Please enjoy its unique scent and mild sweetness.', 'https://safespaces.sgp1.digitaloceanspaces.com/Sencha.jpg', 'Gyokuro "KOZAN" 70g', 259.00, 0, 5, '2018-03-10 12:04:13');
INSERT INTO "public"."product_info" VALUES ('B0002', 0, '2018-03-10 10:35:43', 'With hints of floral and dried longan notes, this Pu Er is harvested at Banpen Village with an altitude of 1760 meters. The brownish red brew is slightly in the bitter side and suits the palates of tea enthusiast that prefers a strong tasting tea.', 'https://safespaces.sgp1.digitaloceanspaces.com/Ban-Pen-Pu-Er-2019.jpg', 'Ban Pen Ancient Tea Tree 2019 50g', 78.00, 0, 20, '2018-03-10 10:35:43');
INSERT INTO "public"."product_info" VALUES ('C0001', 2, '2018-03-10 12:09:41', 'Developed in 1980, this special Oolong was made to exhibit a light milky aroma. Produced in Nantou and Jayi regions of Taiwan, Jin Xuan is manufactured only by tea trees that grow above the altitude of 1000m. The tea leaves are a vivid dark green and are rolled into small pearls. When brewed, the tea exhibits an aroma of milk, while tasting creamy and incredibly light on the palate.', 'https://safespaces.sgp1.digitaloceanspaces.com/Jin-Xuan.jpg', 'Jin Xuan Oolong 30g', 39.00, 0, 15, '2018-03-10 12:09:41');
INSERT INTO "public"."product_info" VALUES ('C0002', 2, '2018-03-10 12:09:41', 'Produced in Nantou and Jayi regions of Taiwan, Dong Ding Oolong is manufactured only by tea trees that grow above the altitude of 1200m. The tea leaves are a vivid dark green and are rolled into small pearls. When brewed, the tea exhibits an aroma of flowers and is incredibly light on the palate.', 'https://safespaces.sgp1.digitaloceanspaces.com/Dong-Ding.jpg', 'Dong Ding Oolong 100g', 50.00, 0, 15, '2018-03-10 12:09:41');
INSERT INTO "public"."product_info" VALUES ('C0003', 2, '2018-03-10 12:11:51', 'Tie Guan Yin is the most well-known light fermented Oolong tea from Fu Jian An Xi of China. This medium-bodied tea is falls between green and red tea in both character and colour.', 'https://safespaces.sgp1.digitaloceanspaces.com/Supreme-Tie-Guan-Yin.jpg', 'Supreme Tie Guan Yin 30g', 35.00, 0, 88, '2018-03-10 12:11:51');
INSERT INTO "public"."product_info" VALUES ('B0001', 0, '2018-03-10 06:44:25', 'Produced in Fujian Fu Ding, White Peony is a mildly fermented tea that is very lightly processed. This white tea is made from tender shoots of the tea leaves to make a premium grade cup of tea. It has a pleasantly sweet taste that is similar to that of fruit and honey.', 'https://safespaces.sgp1.digitaloceanspaces.com/White-Peony.jpg', 'White Peony 80g', 60.00, 0, 96, '2018-03-10 06:44:25');
INSERT INTO "public"."product_info" VALUES ('B0004', 0, '2018-03-10 10:39:29', 'Osmanthus Tea is a blend of the sweet-scented Osmanthus and Oolong tea, a favourite among floral tea lovers for its full-bodied, flowery honey notes.', 'https://safespaces.sgp1.digitaloceanspaces.com/Osmanthus-Tea.jpg', 'Osmanthus Tea 50g', 24.00, 1, 0, '2018-03-10 10:39:32');
INSERT INTO "public"."product_info" VALUES ('B0005', 0, '2018-03-10 10:40:35', 'Silver Needles is an imperial harvest tea that is produced in Fu Jian province of China. Consisting of purely pekoes from the tea plant, Silver Needles has a sweet velvety taste and mouthfeel. The tea is minimally processed and simply dried.', 'https://safespaces.sgp1.digitaloceanspaces.com/Silver-Needles.jpg', 'Silver Needles 100g', 140.00, 0, 19, '2018-03-10 10:40:35');
INSERT INTO "public"."product_info" VALUES ('D0002', 3, '2018-03-10 12:08:17', 'This Shincha is the first harvest of the tea harvesting season. We pick freshly grown young tea buds to provide quality green tea in Yamashiro, Kyoto, the most famous green tea producing area in Japan. Shincha has a light and fresh fragrant aroma', 'https://safespaces.sgp1.digitaloceanspaces.com/highsencha.jpg', 'Shin ichibancha Kyoto 50g', 39.00, 0, 0, '2018-03-10 12:08:17');
INSERT INTO "public"."product_info" VALUES ('F0001', 1, '2018-03-10 12:15:05', 'One of the three most famous types of red tea, the Orange Pekoe Tea makes a versatile beverage that can be paired with most types of food.', 'https://safespaces.sgp1.digitaloceanspaces.com/Kee-Mun-Red-Tea.jpg', 'Orange Pekoe Ceylon Tea 100g', 49.00, 0, 57, '2018-03-10 12:15:10');
INSERT INTO "public"."product_info" VALUES ('F0002', 1, '2018-03-10 12:16:44', 'Lapsang Souchong is a red tea originated from the Wuyi region of Fujian, best known for its uniquely smoky scent. In its processing, the tea is smoked with pine fire, sure to remind you of a barbecue or a campfire.', 'https://safespaces.sgp1.digitaloceanspaces.com/Lapsang-SouChong.jpg', 'Lapsang Souchong 50g', 20.00, 0, 22, '2018-03-10 12:16:44');
INSERT INTO "public"."product_info" VALUES ('F0003', 1, '2018-03-10 12:16:44', 'Named as one of the great four of Wuyi mountain, Iron Arhat is grown in between the rocky mountain of northern Fujian province. Iron Arhat embodies a strong flavour and scent that blends fruit and charcoal.', 'https://safespaces.sgp1.digitaloceanspaces.com/Iron-Arhat.jpg', 'Iron Arhat', 88.00, 1, 0, '2018-03-10 12:16:44');
INSERT INTO "public"."product_info" VALUES ('B0006', 0, '2018-03-10 10:39:29', 'This uniquely-shaped high-grade variant combines the light-bodied green tea with superior grade Jasmine flowers for a refreshing floral twist enjoyed by green tea lowers.', 'https://safespaces.sgp1.digitaloceanspaces.com/Jasmine-Pearls.jpg', 'Osmanthus Tea 50g', 24.00, 1, 0, '2018-03-10 10:39:32');

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO "public"."users" VALUES (2147483641, 't', '3200 West Road', 'customer1@email.com', 'customer1', '$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu', '123456789', 'ROLE_CUSTOMER');
INSERT INTO "public"."users" VALUES (2147483642, 't', '2000 John Road', 'manager1@email.com', 'manager1', '$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu', '987654321', 'ROLE_MANAGER');
INSERT INTO "public"."users" VALUES (2147483643, 't', '222 East Drive ', 'employee1@email.com', 'employee1', '$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu', '123123122', 'ROLE_EMPLOYEE');
INSERT INTO "public"."users" VALUES (2147483645, 't', '3100 Western Road A', 'customer2@email.com', 'customer2', '$2a$10$0oho5eUbDqKrLH026A2YXuCGnpq07xJpuG/Qu.PYb1VCvi2VMXWNi', '2343456', 'ROLE_CUSTOMER');

-- ----------------------------
-- Records of cart
-- ----------------------------
INSERT INTO "public"."cart" VALUES (2147483641);
INSERT INTO "public"."cart" VALUES (2147483642);
INSERT INTO "public"."cart" VALUES (2147483643);
INSERT INTO "public"."cart" VALUES (2147483645);


