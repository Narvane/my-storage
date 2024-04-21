-- Adicionando o novo atributo userLogin à tabela FOOD
ALTER TABLE FOOD
    ADD COLUMN user_login VARCHAR(255) NOT NULL DEFAULT 'userAdmin';

-- Adicionando o novo atributo userLogin à tabela MEAL
ALTER TABLE MEAL
    ADD COLUMN user_login VARCHAR(255) NOT NULL DEFAULT 'userAdmin';

-- Adicionando o novo atributo userLogin à tabela MEAL_PORTIONS
ALTER TABLE MEAL_PORTIONS
    ADD COLUMN user_login VARCHAR(255) NOT NULL DEFAULT 'userAdmin';