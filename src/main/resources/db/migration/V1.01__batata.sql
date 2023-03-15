CREATE TABLE batata (
    id   INTEGER AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(30) NOT NULL,
    type VARCHAR(50),
    father_id INTEGER,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP NOT NULL
);

ALTER TABLE if exists batata
      ADD CONSTRAINT father_batata_batata_fk
      FOREIGN KEY (father_id) REFERENCES father_batata