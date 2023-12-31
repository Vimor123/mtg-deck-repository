INSERT INTO PLAYER (player_id, username, password, administrator) VALUES (1000001, 'admin', 'password', TRUE);
INSERT INTO PLAYER (player_id, username, password, administrator) VALUES (1000002, 'dean', '123456', FALSE);

INSERT INTO DECK (deck_id, player_id, deck_name, format) VALUES (1000001, 1000001, 'Boros Synthesizer', 'Pauper');
INSERT INTO CARD_IN_DECK (card_in_deck_id, deck_id, card_name, quantity, in_main_deck) VALUES (1000001, 1000001, 'Glint Hawk', 4, TRUE);
INSERT INTO CARD_IN_DECK (card_in_deck_id, deck_id, card_name, quantity, in_main_deck) VALUES (1000002, 1000001, 'Krark-Clan Shaman', 2, TRUE);
INSERT INTO CARD_IN_DECK (card_in_deck_id, deck_id, card_name, quantity, in_main_deck) VALUES (1000003, 1000001, 'Thraben Inspector', 4, TRUE);
INSERT INTO CARD_IN_DECK (card_in_deck_id, deck_id, card_name, quantity, in_main_deck) VALUES (1000004, 1000001, 'Dawnbringer Cleric', 2, TRUE);
INSERT INTO CARD_IN_DECK (card_in_deck_id, deck_id, card_name, quantity, in_main_deck) VALUES (1000005, 1000001, 'Kor Skyfisher', 4, TRUE);
INSERT INTO CARD_IN_DECK (card_in_deck_id, deck_id, card_name, quantity, in_main_deck) VALUES (1000006, 1000001, 'Galvanic Blast', 4, TRUE);
INSERT INTO CARD_IN_DECK (card_in_deck_id, deck_id, card_name, quantity, in_main_deck) VALUES (1000007, 1000001, 'Lightning Bolt', 4, TRUE);
INSERT INTO CARD_IN_DECK (card_in_deck_id, deck_id, card_name, quantity, in_main_deck) VALUES (1000008, 1000001, 'Foundry Helix', 2, TRUE);
INSERT INTO CARD_IN_DECK (card_in_deck_id, deck_id, card_name, quantity, in_main_deck) VALUES (1000009, 1000001, 'Experimental Synthesizer', 4, TRUE);
INSERT INTO CARD_IN_DECK (card_in_deck_id, deck_id, card_name, quantity, in_main_deck) VALUES (10000010, 1000001, 'Barbed Batterfist', 2, TRUE);
INSERT INTO CARD_IN_DECK (card_in_deck_id, deck_id, card_name, quantity, in_main_deck) VALUES (10000011, 1000001, 'Ichor Wellspring', 3, TRUE);
INSERT INTO CARD_IN_DECK (card_in_deck_id, deck_id, card_name, quantity, in_main_deck) VALUES (10000012, 1000001, 'Lembas', 4, TRUE);
INSERT INTO CARD_IN_DECK (card_in_deck_id, deck_id, card_name, quantity, in_main_deck) VALUES (10000013, 1000001, 'Makeshift Munitions', 1, TRUE);
INSERT INTO CARD_IN_DECK (card_in_deck_id, deck_id, card_name, quantity, in_main_deck) VALUES (10000014, 1000001, 'Ancient Den', 4, TRUE);
INSERT INTO CARD_IN_DECK (card_in_deck_id, deck_id, card_name, quantity, in_main_deck) VALUES (10000015, 1000001, 'Great Furnace', 4, TRUE);
INSERT INTO CARD_IN_DECK (card_in_deck_id, deck_id, card_name, quantity, in_main_deck) VALUES (11000006, 1000001, 'Mountain', 2, TRUE);
INSERT INTO CARD_IN_DECK (card_in_deck_id, deck_id, card_name, quantity, in_main_deck) VALUES (10000017, 1000001, 'Plains', 2, TRUE);
INSERT INTO CARD_IN_DECK (card_in_deck_id, deck_id, card_name, quantity, in_main_deck) VALUES (10000018, 1000001, 'Radiant Fountain', 1, TRUE);
INSERT INTO CARD_IN_DECK (card_in_deck_id, deck_id, card_name, quantity, in_main_deck) VALUES (10000019, 1000001, 'Rustvale Bridge', 4, TRUE);
INSERT INTO CARD_IN_DECK (card_in_deck_id, deck_id, card_name, quantity, in_main_deck) VALUES (10000020, 1000001, 'Wind-Scarred Crag', 3, TRUE);
INSERT INTO CARD_IN_DECK (card_in_deck_id, deck_id, card_name, quantity, in_main_deck) VALUES (10000021, 1000001, 'Pyroblast', 4, FALSE);
INSERT INTO CARD_IN_DECK (card_in_deck_id, deck_id, card_name, quantity, in_main_deck) VALUES (10000022, 1000001, 'Relic of Progenitus', 2, FALSE);
INSERT INTO CARD_IN_DECK (card_in_deck_id, deck_id, card_name, quantity, in_main_deck) VALUES (10000023, 1000001, 'Cast into the Fire', 2, FALSE);
INSERT INTO CARD_IN_DECK (card_in_deck_id, deck_id, card_name, quantity, in_main_deck) VALUES (10000024, 1000001, 'Destroy Evil', 4, FALSE);
INSERT INTO CARD_IN_DECK (card_in_deck_id, deck_id, card_name, quantity, in_main_deck) VALUES (10000025, 1000001, 'Lone Missionary', 3, FALSE);

INSERT INTO DECK (deck_id, player_id, deck_name, format) VALUES (1000002, 1000002, 'Dimir Control', 'Pauper');
INSERT INTO CARD_IN_DECK (card_in_deck_id, deck_id, card_name, quantity, in_main_deck) VALUES (10000026, 1000002, 'Augur of Bolas', 4, TRUE);
INSERT INTO CARD_IN_DECK (card_in_deck_id, deck_id, card_name, quantity, in_main_deck) VALUES (10000027, 1000002, 'Murmuring Mystic', 2, TRUE);
INSERT INTO CARD_IN_DECK (card_in_deck_id, deck_id, card_name, quantity, in_main_deck) VALUES (10000028, 1000002, 'Thorn of the Black Rose', 2, TRUE);
INSERT INTO CARD_IN_DECK (card_in_deck_id, deck_id, card_name, quantity, in_main_deck) VALUES (10000029, 1000002, 'Tolarian Terror', 4, TRUE);
INSERT INTO CARD_IN_DECK (card_in_deck_id, deck_id, card_name, quantity, in_main_deck) VALUES (10000030, 1000002, 'Brainstorm', 4, TRUE);
INSERT INTO CARD_IN_DECK (card_in_deck_id, deck_id, card_name, quantity, in_main_deck) VALUES (10000031, 1000002, 'Dispel', 1, TRUE);
INSERT INTO CARD_IN_DECK (card_in_deck_id, deck_id, card_name, quantity, in_main_deck) VALUES (10000032, 1000002, 'Ponder', 3, TRUE);
INSERT INTO CARD_IN_DECK (card_in_deck_id, deck_id, card_name, quantity, in_main_deck) VALUES (10000033, 1000002, 'Preordain', 1, TRUE);
INSERT INTO CARD_IN_DECK (card_in_deck_id, deck_id, card_name, quantity, in_main_deck) VALUES (10000034, 1000002, 'Spell Pierce', 2, TRUE);
INSERT INTO CARD_IN_DECK (card_in_deck_id, deck_id, card_name, quantity, in_main_deck) VALUES (10000035, 1000002, 'Cast Down', 2, TRUE);
INSERT INTO CARD_IN_DECK (card_in_deck_id, deck_id, card_name, quantity, in_main_deck) VALUES (10000036, 1000002, 'Counterspell', 4, TRUE);
INSERT INTO CARD_IN_DECK (card_in_deck_id, deck_id, card_name, quantity, in_main_deck) VALUES (10000037, 1000002, 'Echoing Decay', 2, TRUE);
INSERT INTO CARD_IN_DECK (card_in_deck_id, deck_id, card_name, quantity, in_main_deck) VALUES (10000038, 1000002, 'Unexpected Fangs', 1, TRUE);
INSERT INTO CARD_IN_DECK (card_in_deck_id, deck_id, card_name, quantity, in_main_deck) VALUES (10000039, 1000002, 'Suffocating Fumes', 1, TRUE);
INSERT INTO CARD_IN_DECK (card_in_deck_id, deck_id, card_name, quantity, in_main_deck) VALUES (10000040, 1000002, 'Snuff Out', 4, TRUE);
INSERT INTO CARD_IN_DECK (card_in_deck_id, deck_id, card_name, quantity, in_main_deck) VALUES (10000041, 1000002, 'Lorien Revealed', 4, TRUE);
INSERT INTO CARD_IN_DECK (card_in_deck_id, deck_id, card_name, quantity, in_main_deck) VALUES (10000042, 1000002, 'Bojuka Bog', 1, TRUE);
INSERT INTO CARD_IN_DECK (card_in_deck_id, deck_id, card_name, quantity, in_main_deck) VALUES (10000043, 1000002, 'Contaminated Aquifer', 4, TRUE);
INSERT INTO CARD_IN_DECK (card_in_deck_id, deck_id, card_name, quantity, in_main_deck) VALUES (10000044, 1000002, 'Island', 10, TRUE);
INSERT INTO CARD_IN_DECK (card_in_deck_id, deck_id, card_name, quantity, in_main_deck) VALUES (10000045, 1000002, 'Maestros Theater', 2, TRUE);
INSERT INTO CARD_IN_DECK (card_in_deck_id, deck_id, card_name, quantity, in_main_deck) VALUES (10000046, 1000002, 'Swamp', 2, TRUE);
INSERT INTO CARD_IN_DECK (card_in_deck_id, deck_id, card_name, quantity, in_main_deck) VALUES (10000047, 1000002, 'Blue Elemental Blast', 4, FALSE);
INSERT INTO CARD_IN_DECK (card_in_deck_id, deck_id, card_name, quantity, in_main_deck) VALUES (10000048, 1000002, 'Hydroblast', 1, FALSE);
INSERT INTO CARD_IN_DECK (card_in_deck_id, deck_id, card_name, quantity, in_main_deck) VALUES (10000049, 1000002, 'Nihil Spellbomb', 1, FALSE);
INSERT INTO CARD_IN_DECK (card_in_deck_id, deck_id, card_name, quantity, in_main_deck) VALUES (10000050, 1000002, 'Rotten Reunion', 1, FALSE);
INSERT INTO CARD_IN_DECK (card_in_deck_id, deck_id, card_name, quantity, in_main_deck) VALUES (10000051, 1000002, 'Steel Sabotage', 2, FALSE);
INSERT INTO CARD_IN_DECK (card_in_deck_id, deck_id, card_name, quantity, in_main_deck) VALUES (10000052, 1000002, 'Chainer''s Edict', 2, FALSE);
INSERT INTO CARD_IN_DECK (card_in_deck_id, deck_id, card_name, quantity, in_main_deck) VALUES (10000053, 1000002, 'Echoing Decay', 1, FALSE);
INSERT INTO CARD_IN_DECK (card_in_deck_id, deck_id, card_name, quantity, in_main_deck) VALUES (10000054, 1000002, 'Unexpected Fangs', 1, FALSE);
INSERT INTO CARD_IN_DECK (card_in_deck_id, deck_id, card_name, quantity, in_main_deck) VALUES (10000055, 1000002, 'Drown in Sorrow', 1, FALSE);
INSERT INTO CARD_IN_DECK (card_in_deck_id, deck_id, card_name, quantity, in_main_deck) VALUES (10000056, 1000002, 'Thorn of the Black Rose', 1, FALSE);

INSERT INTO DECK (deck_id, player_id, deck_name, format) VALUES (1000003, 1000002, 'Amulet Titan', 'Modern');
INSERT INTO CARD_IN_DECK (card_in_deck_id, deck_id, card_name, quantity, in_main_deck) VALUES (10000057, 1000003, 'Arboreal Grazer', 4, TRUE);
INSERT INTO CARD_IN_DECK (card_in_deck_id, deck_id, card_name, quantity, in_main_deck) VALUES (10000058, 1000003, 'Azusa, Lost but Seeking', 1, TRUE);
INSERT INTO CARD_IN_DECK (card_in_deck_id, deck_id, card_name, quantity, in_main_deck) VALUES (10000059, 1000003, 'Dryad of the Ilysian Grove', 4, TRUE);
INSERT INTO CARD_IN_DECK (card_in_deck_id, deck_id, card_name, quantity, in_main_deck) VALUES (10000060, 1000003, 'Primeval Titan', 4, TRUE);
INSERT INTO CARD_IN_DECK (card_in_deck_id, deck_id, card_name, quantity, in_main_deck) VALUES (10000061, 1000003, 'Cultivator Colossus', 1, TRUE);
INSERT INTO CARD_IN_DECK (card_in_deck_id, deck_id, card_name, quantity, in_main_deck) VALUES (10000062, 1000003, 'Summoner''s Pact', 4, TRUE);
INSERT INTO CARD_IN_DECK (card_in_deck_id, deck_id, card_name, quantity, in_main_deck) VALUES (10000063, 1000003, 'Amulet of Vigor', 4, TRUE);
INSERT INTO CARD_IN_DECK (card_in_deck_id, deck_id, card_name, quantity, in_main_deck) VALUES (10000064, 1000003, 'Expedition Map', 1, TRUE);
INSERT INTO CARD_IN_DECK (card_in_deck_id, deck_id, card_name, quantity, in_main_deck) VALUES (10000065, 1000003, 'The One Ring', 4, TRUE);
INSERT INTO CARD_IN_DECK (card_in_deck_id, deck_id, card_name, quantity, in_main_deck) VALUES (10000066, 1000003, 'Spelunking', 2, TRUE);
INSERT INTO CARD_IN_DECK (card_in_deck_id, deck_id, card_name, quantity, in_main_deck) VALUES (10000067, 1000003, 'Bojuka Bog', 1, TRUE);
INSERT INTO CARD_IN_DECK (card_in_deck_id, deck_id, card_name, quantity, in_main_deck) VALUES (10000068, 1000003, 'Boros Garrison', 1, TRUE);
INSERT INTO CARD_IN_DECK (card_in_deck_id, deck_id, card_name, quantity, in_main_deck) VALUES (10000069, 1000003, 'Boseiju, Who Endures', 3, TRUE);
INSERT INTO CARD_IN_DECK (card_in_deck_id, deck_id, card_name, quantity, in_main_deck) VALUES (10000070, 1000003, 'Cavern of Souls', 1, TRUE);
INSERT INTO CARD_IN_DECK (card_in_deck_id, deck_id, card_name, quantity, in_main_deck) VALUES (10000071, 1000003, 'Forest', 4, TRUE);
INSERT INTO CARD_IN_DECK (card_in_deck_id, deck_id, card_name, quantity, in_main_deck) VALUES (10000072, 1000003, 'Golgari Rot Farm', 3, TRUE);
INSERT INTO CARD_IN_DECK (card_in_deck_id, deck_id, card_name, quantity, in_main_deck) VALUES (10000073, 1000003, 'Gruul Turf', 1, TRUE);
INSERT INTO CARD_IN_DECK (card_in_deck_id, deck_id, card_name, quantity, in_main_deck) VALUES (10000074, 1000003, 'Selesnya Sanctuary', 1, TRUE);
INSERT INTO CARD_IN_DECK (card_in_deck_id, deck_id, card_name, quantity, in_main_deck) VALUES (10000075, 1000003, 'Simic Growth Chamber', 4, TRUE);
INSERT INTO CARD_IN_DECK (card_in_deck_id, deck_id, card_name, quantity, in_main_deck) VALUES (10000076, 1000003, 'Slayers'' Stronghold', 1, TRUE);
INSERT INTO CARD_IN_DECK (card_in_deck_id, deck_id, card_name, quantity, in_main_deck) VALUES (10000077, 1000003, 'Sunhome, Fortress of the Legion', 1, TRUE);
INSERT INTO CARD_IN_DECK (card_in_deck_id, deck_id, card_name, quantity, in_main_deck) VALUES (10000078, 1000003, 'The Mycosynth Gardens', 2, TRUE);
INSERT INTO CARD_IN_DECK (card_in_deck_id, deck_id, card_name, quantity, in_main_deck) VALUES (10000079, 1000003, 'Tolaria West', 2, TRUE);
INSERT INTO CARD_IN_DECK (card_in_deck_id, deck_id, card_name, quantity, in_main_deck) VALUES (10000080, 1000003, 'Urza''s Saga', 4, TRUE);
INSERT INTO CARD_IN_DECK (card_in_deck_id, deck_id, card_name, quantity, in_main_deck) VALUES (10000081, 1000003, 'Valakut, The Molten Pinnacle', 2, TRUE);
INSERT INTO CARD_IN_DECK (card_in_deck_id, deck_id, card_name, quantity, in_main_deck) VALUES (10000082, 1000003, 'Vesuva', 1, TRUE);
INSERT INTO CARD_IN_DECK (card_in_deck_id, deck_id, card_name, quantity, in_main_deck) VALUES (10000083, 1000003, 'Boseiju, Who Endures', 1, FALSE);
INSERT INTO CARD_IN_DECK (card_in_deck_id, deck_id, card_name, quantity, in_main_deck) VALUES (10000084, 1000003, 'Engineered Explosives', 2, FALSE);
INSERT INTO CARD_IN_DECK (card_in_deck_id, deck_id, card_name, quantity, in_main_deck) VALUES (10000085, 1000003, 'Swan Song', 2, FALSE);
INSERT INTO CARD_IN_DECK (card_in_deck_id, deck_id, card_name, quantity, in_main_deck) VALUES (10000086, 1000003, 'Tear Asunder', 2, FALSE);
INSERT INTO CARD_IN_DECK (card_in_deck_id, deck_id, card_name, quantity, in_main_deck) VALUES (10000087, 1000003, 'Dismember', 3, FALSE);
INSERT INTO CARD_IN_DECK (card_in_deck_id, deck_id, card_name, quantity, in_main_deck) VALUES (10000088, 1000003, 'Endurance', 2, FALSE);
INSERT INTO CARD_IN_DECK (card_in_deck_id, deck_id, card_name, quantity, in_main_deck) VALUES (10000089, 1000003, 'Force of Vigor', 1, FALSE);
INSERT INTO CARD_IN_DECK (card_in_deck_id, deck_id, card_name, quantity, in_main_deck) VALUES (10000090, 1000003, 'Generous Ent', 2, TRUE);