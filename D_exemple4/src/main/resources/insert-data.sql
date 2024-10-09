insert into PROJET(CODEPROJET,NOMPROJET,STATUT) values ('COSE-TOUJOURS','Exploiter Cosette','ENCOURS'),('EGOUTS','Vivre de rapines dans les égouts','ENCOURS');

insert into MACHINE(IDMACHINE,ADRESSEMAC,MODELE) values (1,'AE:B3:56:57:33','CRAY X-MP'),(2,'AE:B3:56:34:88','APPLE 2E');

insert into TELEPHONE(IDTEL,NUMERO,MODELE) values (1,'0606060606','Galaxy quest'),(2,'0712345678','Fairphone 3'),(3,'0601010101','BlackBerry');

insert into PAYS(CODEPAYS,NOMPAYS) values ('FR','FRANCE');
insert into ADRESSE(IDADRESSE,RUE,CODEPOSTAL,VILLE,CODEPAYS) values (1,'13, Rue des misérables',75003,'PARIS','FR');
insert into EMPLOYES(IDEMP,NOMEMP,PRENOMEMP,IDADRESSE,IDMACHINE) values (1,'Valjean','Jean',1,1);
insert into EMPLOYES(IDEMP,NOMEMP,PRENOMEMP) values (2,'Javert','Inspecteur'),(3,'Thénardier','Eponine'),(4,'Thénardier','Alzema'),(5,'Thénardier','Maître'),(6,'Thénardier','Madame'), (7,'Le Surineur','Jeannot');

insert into PROJETSENCOURS(IDEMP,CODEPROJET) values(3,'COSE-TOUJOURS'), (4,'COSE-TOUJOURS'), (5,'COSE-TOUJOURS'), (6,'COSE-TOUJOURS');
insert into PROJETSENCOURS(IDEMP,CODEPROJET) values(5,'EGOUTS'),(7,'EGOUTS');

insert into TELEPHONEDE(IDEMP,IDTEL) values (2,1),(1,2);