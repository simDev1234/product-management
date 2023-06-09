-- 대분류
insert into category (category_code, category_name, created_at, updated_at)
values ('01', '패션', '2023-06-09T18:00', '2023-06-09T18:00') on duplicate key update category_code = values(category_code);

insert into category (category_code, category_name, created_at, updated_at)
values ('02', '디지털/가전', '2023-06-09T18:00', '2023-06-09T18:00') on duplicate key update category_code = values(category_code);

insert into category (category_code, category_name, created_at, updated_at)
values ('03', '일상용품', '2023-06-09T18:00', '2023-06-09T18:00') on duplicate key update category_code = values(category_code);

-- 중분류
insert into category (category_code, category_name, created_at, updated_at)
values ('0101', '여성', '2023-06-09T18:00', '2023-06-09T18:00') on duplicate key update category_code = values(category_code);

insert into category (category_code, category_name, created_at, updated_at)
values ('0102', '남성', '2023-06-09T18:00', '2023-06-09T18:00') on duplicate key update category_code = values(category_code);

insert into category (category_code, category_name, created_at, updated_at)
values ('0103', '키즈', '2023-06-09T18:00', '2023-06-09T18:00') on duplicate key update category_code = values(category_code);

insert into category (category_code, category_name, created_at, updated_at)
values ('0104', '공용', '2023-06-09T18:00', '2023-06-09T18:00') on duplicate key update category_code = values(category_code);

insert into category (category_code, category_name, created_at, updated_at)
values ('0201', '휴대폰악세서리', '2023-06-09T18:00', '2023-06-09T18:00') on duplicate key update category_code = values(category_code);

insert into category (category_code, category_name, created_at, updated_at)
values ('0301', '화장품', '2023-06-09T18:00', '2023-06-09T18:00') on duplicate key update category_code = values(category_code);

-- 소분류
insert into category (category_code, category_name, created_at, updated_at)
values ('010101', '여성의류', '2023-06-09T18:00', '2023-06-09T18:00') on duplicate key update category_code = values(category_code);

insert into category (category_code, category_name, created_at, updated_at)
values ('010102', '여성잡화', '2023-06-09T18:00', '2023-06-09T18:00') on duplicate key update category_code = values(category_code);

insert into category (category_code, category_name, created_at, updated_at)
values ('010201', '남성의류', '2023-06-09T18:00', '2023-06-09T18:00') on duplicate key update category_code = values(category_code);

insert into category (category_code, category_name, created_at, updated_at)
values ('010201', '남성잡화', '2023-06-09T18:00', '2023-06-09T18:00') on duplicate key update category_code = values(category_code);

insert into category (category_code, category_name, created_at, updated_at)
values ('010301', '키즈의류', '2023-06-09T18:00', '2023-06-09T18:00') on duplicate key update category_code = values(category_code);

insert into category (category_code, category_name, created_at, updated_at)
values ('010401', '공용의류', '2023-06-09T18:00', '2023-06-09T18:00') on duplicate key update category_code = values(category_code);

insert into category (category_code, category_name, created_at, updated_at)
values ('020101', '휴대폰케이스', '2023-06-09T18:00', '2023-06-09T18:00') on duplicate key update category_code = values(category_code);

insert into category (category_code, category_name, created_at, updated_at)
values ('030101', '스킨케어', '2023-06-09T18:00', '2023-06-09T18:00') on duplicate key update category_code = values(category_code);

-- 세분류
insert into category (category_code, category_name, created_at, updated_at)
values ('01010101', '원피스', '2023-06-09T18:00', '2023-06-09T18:00') on duplicate key update category_code = values(category_code);

insert into category (category_code, category_name, created_at, updated_at)
values ('01010102', '투피스', '2023-06-09T18:00', '2023-06-09T18:00') on duplicate key update category_code = values(category_code);

insert into category (category_code, category_name, created_at, updated_at)
values ('01020101', '남성정장세트', '2023-06-09T18:00', '2023-06-09T18:00') on duplicate key update category_code = values(category_code);

insert into category (category_code, category_name, created_at, updated_at)
values ('01020102', '남성장장재킷', '2023-06-09T18:00', '2023-06-09T18:00') on duplicate key update category_code = values(category_code);

insert into category (category_code, category_name, created_at, updated_at)
values ('01030101', '셔츠/남방', '2023-06-09T18:00', '2023-06-09T18:00') on duplicate key update category_code = values(category_code);

insert into category (category_code, category_name, created_at, updated_at)
values ('01030102', '점퍼', '2023-06-09T18:00', '2023-06-09T18:00') on duplicate key update category_code = values(category_code);

insert into category (category_code, category_name, created_at, updated_at)
values ('01030103', '티셔츠', '2023-06-09T18:00', '2023-06-09T18:00') on duplicate key update category_code = values(category_code);

insert into category (category_code, category_name, created_at, updated_at)
values ('01040101', '공용티셔츠', '2023-06-09T18:00', '2023-06-09T18:00') on duplicate key update category_code = values(category_code);

insert into category (category_code, category_name, created_at, updated_at)
values ('01040102', '공용자캣', '2023-06-09T18:00', '2023-06-09T18:00') on duplicate key update category_code = values(category_code);

insert into category (category_code, category_name, created_at, updated_at)
values ('01010201', '여성신발', '2023-06-09T18:00', '2023-06-09T18:00') on duplicate key update category_code = values(category_code);

insert into category (category_code, category_name, created_at, updated_at)
values ('01020201', '남성신발', '2023-06-09T18:00', '2023-06-09T18:00') on duplicate key update category_code = values(category_code);

insert into category (category_code, category_name, created_at, updated_at)
values ('02010101', '아이폰케이스', '2023-06-09T18:00', '2023-06-09T18:00') on duplicate key update category_code = values(category_code);

insert into category (category_code, category_name, created_at, updated_at)
values ('02010102', '안드로이드케이스', '2023-06-09T18:00', '2023-06-09T18:00') on duplicate key update category_code = values(category_code);

insert into category (category_code, category_name, created_at, updated_at)
values ('03010101', '바디클렌저', '2023-06-09T18:00', '2023-06-09T18:00') on duplicate key update category_code = values(category_code);

insert into category (category_code, category_name, created_at, updated_at)
values ('03010102', '바디스크럽', '2023-06-09T18:00', '2023-06-09T18:00') on duplicate key update category_code = values(category_code);

insert into category (category_code, category_name, created_at, updated_at)
values ('03010103', '풋케어', '2023-06-09T18:00', '2023-06-09T18:00') on duplicate key update category_code = values(category_code);