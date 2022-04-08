CREATE TABLE IF NOT EXISTS company
(
    id      BIGSERIAL PRIMARY KEY,
    name    VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS product
(
    id                  BIGSERIAL PRIMARY KEY,
    company_id          BIGINT NOT NULL,
    name                VARCHAR(255) NOT NULL,
    business_segment    VARCHAR(255) NOT NULL,
    CONSTRAINT companyidproductfk FOREIGN KEY (company_id) REFERENCES company
);

CREATE TABLE IF NOT EXISTS member
(
    id                  BIGSERIAL PRIMARY KEY,
    product_id          BIGINT NOT NULL,
    name                VARCHAR(255) NOT NULL,
    business_segment    VARCHAR(255) NOT NULL,
    document            VARCHAR(255) NOT NULL,
    document_type       VARCHAR(255) NOT NULL,
    CONSTRAINT productidmemberfk FOREIGN KEY (product_id) REFERENCES product,
);