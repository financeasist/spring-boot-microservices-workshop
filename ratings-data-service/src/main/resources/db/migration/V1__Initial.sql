CREATE TABLE IF NOT EXISTS user_ratings
(
  id           BIGINT NOT NULL AUTO_INCREMENT,
  user_id      VARCHAR(255) NOT NULL,
  movie_id     VARCHAR(255) NOT NULL,
  rating_value VARCHAR(255),
PRIMARY KEY(id)
);