# This script creates the entire cinema schema and inserts sample data for lead_actor, lead_actress and movie tables
CREATE SCHEMA `cinema` ;

CREATE TABLE `cinema`.`lead_actress` (
  `lead_actress_id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(60) NOT NULL,
  `age` INT NOT NULL,
  `academy_awards` INT NOT NULL,
  `image_url` VARCHAR(200) NOT NULL,
  `imdb_url` VARCHAR(200) NOT NULL,
  PRIMARY KEY (`lead_actress_id`));
  
  CREATE TABLE `cinema`.`lead_actor` (
  `lead_actor_id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(60) NOT NULL,
  `age` INT NOT NULL,
  `academy_awards` INT NOT NULL,
  `image_url` VARCHAR(200) NOT NULL,
  `imdb_url` VARCHAR(200) NOT NULL,
  PRIMARY KEY (`lead_actor_id`));
  
  CREATE TABLE `cinema`.`movie` (
  `movie_id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NOT NULL,
  `genre` VARCHAR(30) NOT NULL,
  `release_year` INT NOT NULL,
  `lead_actor_id` INT NOT NULL,
  `lead_actress_id` INT NOT NULL,
  `box_office_gross` INT NOT NULL,
  `image_url` VARCHAR(200) NOT NULL,
  `imdb_url` VARCHAR(200) NOT NULL,
  PRIMARY KEY (`movie_id`),
  INDEX `lead_actor_id_idx` (`lead_actor_id` ASC) VISIBLE,
  INDEX `lead_actress_id_idx` (`lead_actress_id` ASC) VISIBLE,
  CONSTRAINT `lead_actor_id`
    FOREIGN KEY (`lead_actor_id`)
    REFERENCES `cinema`.`lead_actor` (`lead_actor_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `lead_actress_id`
    FOREIGN KEY (`lead_actress_id`)
    REFERENCES `cinema`.`lead_actress` (`lead_actress_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
    
INSERT INTO `cinema`.`lead_actress` (name, age, academy_awards, image_url, imdb_url)
	VALUES ('Carrie Fisher', 60, 0, 'https://upload.wikimedia.org/wikipedia/commons/thumb/0/03/Carrie_Fisher_2013-a_straightened.jpg/330px-Carrie_Fisher_2013-a_straightened.jpg', 'https://www.imdb.com/name/nm0000402/?ref_=nv_sr_srsg_0_tt_7_nm_1_q_carrie%2520fish');
INSERT INTO `cinema`.`lead_actress` (name, age, academy_awards, image_url, imdb_url)
	VALUES ('Angela Bassett', 64, 0, 'https://upload.wikimedia.org/wikipedia/commons/thumb/b/b6/Angela_Bassett.jpg/255px-Angela_Bassett.jpg', 'https://www.imdb.com/name/nm0000291/?ref_=nv_sr_srsg_0_tt_1_nm_7_q_angela%2520bass');
INSERT INTO `cinema`.`lead_actress` (name, age, academy_awards, image_url, imdb_url)
	VALUES ('Anya Taylor-Joy', 27, 0, 'https://upload.wikimedia.org/wikipedia/commons/thumb/c/c9/Anya_Taylor-Joy_by_Patrick_Lovell%2C_January_2019.jpg/330px-Anya_Taylor-Joy_by_Patrick_Lovell%2C_January_2019.jpg', 'https://www.imdb.com/name/nm5896355/?ref_=nv_sr_srsg_3_tt_0_nm_8_q_anya');
    
INSERT INTO `cinema`.`lead_actor` (name, age, academy_awards, image_url, imdb_url)
	VALUES ('Harrison Ford', 80, 0, 'https://upload.wikimedia.org/wikipedia/commons/thumb/3/34/Harrison_Ford_by_Gage_Skidmore_3.jpg/330px-Harrison_Ford_by_Gage_Skidmore_3.jpg', 'https://www.imdb.com/name/nm0000148/?ref_=nv_sr_srsg_0_tt_0_nm_8_q_harrison');
INSERT INTO `cinema`.`lead_actor` (name, age, academy_awards, image_url, imdb_url)
	VALUES ('Chadwick Boseman', 43, 0, 'https://cdn.britannica.com/34/221834-050-000BF6F5/American-actor-Chadwick-Boseman-2019.jpg', 'https://www.imdb.com/name/nm1569276/?ref_=nv_sr_srsg_0_tt_0_nm_8_q_chadw');
INSERT INTO `cinema`.`lead_actor` (name, age, academy_awards, image_url, imdb_url)
	VALUES ('John Leguizamo', 62, 0, 'https://upload.wikimedia.org/wikipedia/commons/thumb/5/51/John_Leguizamo_%284701169051%29.jpg/270px-John_Leguizamo_%284701169051%29.jpg', 'https://www.imdb.com/name/nm0000491/?ref_=nv_sr_srsg_0_tt_0_nm_8_q_john%2520le');
    
INSERT INTO `cinema`.`movie` (name, genre, release_year, lead_actor_id, lead_actress_id, box_office_gross, image_url, imdb_url)
	VALUES ('Star Wars: Episode IV - A New Hope', 'Space Opera', 1977, 1, 1, 775800000, 'https://upload.wikimedia.org/wikipedia/en/8/87/StarWarsMoviePoster1977.jpg', 'https://www.imdb.com/title/tt0076759/?ref_=nv_sr_srsg_0_tt_8_nm_0_q_a%2520new%2520hope');
INSERT INTO `cinema`.`movie` (name, genre, release_year, lead_actor_id, lead_actress_id, box_office_gross, image_url, imdb_url)
	VALUES ('Black Panther', 'Superhero', 2018, 2, 2, 1348000000, 'https://upload.wikimedia.org/wikipedia/en/d/d6/Black_Panther_%28film%29_poster.jpg', 'https://www.imdb.com/title/tt1825683/?ref_=nv_sr_srsg_0_tt_7_nm_1_q_black%2520pan');
INSERT INTO `cinema`.`movie` (name, genre, release_year, lead_actor_id, lead_actress_id, box_office_gross, image_url, imdb_url)
	VALUES ('The Menu', 'Comedy Horror', 2022, 3, 3, 79600000, 'https://upload.wikimedia.org/wikipedia/en/d/db/The_Menu_%282022_film%29.jpg', 'https://www.imdb.com/title/tt9764362/?ref_=nv_sr_srsg_0_tt_8_nm_0_q_the%2520menu');


SELECT * FROM lead_actress;
SELECT * FROM lead_actor;
SELECT * FROM movie;
    
    
    
    
    
    
    
    
    
    
    