CREATE TABLE inscription (
    id_inscription INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    date_inscription DATE NOT NULL,
    additional_information TEXT,
    id_client INTEGER NOT NULL,
    id_course INTEGER NOT NULL
);
