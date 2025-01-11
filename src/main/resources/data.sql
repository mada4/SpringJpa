drop table if exists masinile;
create table masinile (Nr_inmatriculare varchar(50) not null, Marca varchar(50) not null, An_fabricatie int not null, Culoare varchar(50), Nr_kilometri int not null);

insert into masinile (Nr_inmatriculare,Marca,An_fabricatie,Culoare,Nr_kilometri)
    values ('TM14MAD', 'BMW', 2014, 'negru', 5000);
insert into masinile (Nr_inmatriculare,Marca,An_fabricatie,Culoare,Nr_kilometri)
    values ('GJ89WMH', 'Audi', 2007, 'negru', 9500);
insert into masinile (Nr_inmatriculare,Marca,An_fabricatie,Culoare,Nr_kilometri)
    values ('B109RPE', 'Renault', 2018, 'alb', 78000);
insert into masinile (Nr_inmatriculare,Marca,An_fabricatie,Culoare,Nr_kilometri)
    values ('AR23CXG', 'Dacia Logan', 2023, 'auriu', 2000);
insert into masinile (Nr_inmatriculare,Marca,An_fabricatie,Culoare,Nr_kilometri)
    values ('GJ24LRS', 'Golf', 2004, 'rosu', 1500);
insert into masinile (Nr_inmatriculare,Marca,An_fabricatie,Culoare,Nr_kilometri)
    values ('GJ45MIH', 'Audi', 2014, 'alb', 11500);