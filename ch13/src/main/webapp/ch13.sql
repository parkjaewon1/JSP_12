create table pds_item (
	id number NOT NULL,
	fileName VARCHAR2(100) NOT NULL,
	fileSize NUMBER,
	description VARCHAR2(255)
);

update pds_item set filename= 'k_'||filename;
