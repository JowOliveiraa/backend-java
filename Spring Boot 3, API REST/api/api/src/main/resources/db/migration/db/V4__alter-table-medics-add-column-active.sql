alter table medics add active tinyint DEFAULT 1;
update medics set active = 1;
