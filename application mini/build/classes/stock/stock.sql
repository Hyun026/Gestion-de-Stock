CREATE TABLE CLIENT (
   ID_CLIENT            int                  auto_increment PRIMARY KEY,
   NOM_CLIENT           varchar(55)             null,
   ADRESSE              varchar(100)         null,
   date_dajoute         varchar(50)             null
   CONTACT              varchar(100)         null
);
CREATE TABLE PRODUIT (
   ID_PRODUIT           int          auto_increment PRIMARY KEY,
   NOM_PRODUIT          varchar(55)             null,
   date_dajoute        datetime             DEFAULT current_timestamp(),
   PRIX                 float                null
);

CREATE TABLE STOCK (
   ID_STOCK             int                  auto_increment PRIMARY KEY,
   ID_PRODUIT           int         not null,
   date_dajoute        datetime             DEFAULT current_timestamp(),
   QUANTITE_DE_PRODUIT  int                  not null,
    FOREIGN KEY (ID_PRODUIT) REFERENCES PRODUIT(ID_PRODUIT) on update cascade on delete cascade
);

CREATE TABLE COMMANDE (
   ID_COMMANDE          int                  auto_increment PRIMARY KEY,
   ID_CLIENT            int                  not null,
   date_dajoute        datetime             DEFAULT current_timestamp(),
   ID_PRODUIT           int                  not null,
   QUANTITE_DE_PRODUIT  int                   null,
    FOREIGN KEY (ID_CLIENT) REFERENCES CLIENT(ID_CLIENT) on update cascade on delete cascade,
    FOREIGN KEY (ID_PRODUIT) REFERENCES PRODUIT(ID_PRODUIT) on update cascade on delete cascade
);
