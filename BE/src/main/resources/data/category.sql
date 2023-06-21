-- 대분류
insert into category (category_id, division, category_code, category_name, created_at, updated_at)
values (1, 'DIVISION1', '01', '패션', '2023-06-09T18:00', '2023-06-09T18:00') on duplicate key update category_id = values(category_id);

insert into category (category_id, division, category_code, category_name, created_at, updated_at)
values (2, 'DIVISION1', '02', '디지털/가전', '2023-06-09T18:00', '2023-06-09T18:00') on duplicate key update category_id = values(category_id);

insert into category (category_id, division, category_code, category_name, created_at, updated_at)
values (3, 'DIVISION1', '03', '일상용품', '2023-06-09T18:00', '2023-06-09T18:00') on duplicate key update category_id = values(category_id);

-- 중분류
insert into category (category_id, division, category_code, category_name, created_at, updated_at)
values (4, 'DIVISION2', '0101', '여성', '2023-06-09T18:00', '2023-06-09T18:00') on duplicate key update category_id = values(category_id);

insert into category (category_id, division, category_code, category_name, created_at, updated_at)
values (5, 'DIVISION2', '0102', '남성', '2023-06-09T18:00', '2023-06-09T18:00') on duplicate key update category_id = values(category_id);

insert into category (category_id, division, category_code, category_name, created_at, updated_at)
values (6, 'DIVISION2', '0103', '키즈', '2023-06-09T18:00', '2023-06-09T18:00') on duplicate key update category_id = values(category_id);

insert into category (category_id, division, category_code, category_name, created_at, updated_at)
values (7, 'DIVISION2', '0104', '공용', '2023-06-09T18:00', '2023-06-09T18:00') on duplicate key update category_id = values(category_id);

insert into category (category_id, division, category_code, category_name, created_at, updated_at)
values (8, 'DIVISION2', '0201', '휴대폰악세서리', '2023-06-09T18:00', '2023-06-09T18:00') on duplicate key update category_id = values(category_id);

insert into category (category_id, division, category_code, category_name, created_at, updated_at)
values (9, 'DIVISION2', '0301', '화장품', '2023-06-09T18:00', '2023-06-09T18:00') on duplicate key update category_id = values(category_id);

-- 소분류
insert into category (category_id, division, category_code, category_name, created_at, updated_at)
values (10, 'DIVISION3', '010101', '여성의류', '2023-06-09T18:00', '2023-06-09T18:00') on duplicate key update category_id = values(category_id);

insert into category (category_id, division, category_code, category_name, created_at, updated_at)
values (11, 'DIVISION3', '010102', '여성잡화', '2023-06-09T18:00', '2023-06-09T18:00') on duplicate key update category_id = values(category_id);

insert into category (category_id, division, category_code, category_name, created_at, updated_at)
values (12, 'DIVISION3', '010201', '남성의류', '2023-06-09T18:00', '2023-06-09T18:00') on duplicate key update category_id = values(category_id);

insert into category (category_id, division, category_code, category_name, created_at, updated_at)
values (13, 'DIVISION3', '010201', '남성잡화', '2023-06-09T18:00', '2023-06-09T18:00') on duplicate key update category_id = values(category_id);

insert into category (category_id, division, category_code, category_name, created_at, updated_at)
values (14, 'DIVISION3', '010301', '키즈의류', '2023-06-09T18:00', '2023-06-09T18:00') on duplicate key update category_id = values(category_id);

insert into category (category_id, division, category_code, category_name, created_at, updated_at)
values (15, 'DIVISION3', '010401', '공용의류', '2023-06-09T18:00', '2023-06-09T18:00') on duplicate key update category_id = values(category_id);

insert into category (category_id, division, category_code, category_name, created_at, updated_at)
values (16, 'DIVISION3', '020101', '휴대폰케이스', '2023-06-09T18:00', '2023-06-09T18:00') on duplicate key update category_id = values(category_id);

insert into category (category_id, division, category_code, category_name, created_at, updated_at)
values (17, 'DIVISION3', '030101', '스킨케어', '2023-06-09T18:00', '2023-06-09T18:00') on duplicate key update category_id = values(category_id);

-- 세분류
insert into category (category_id, division, category_code, category_name, created_at, updated_at)
values (18, 'DIVISION4', '01010101', '원피스', '2023-06-09T18:00', '2023-06-09T18:00') on duplicate key update category_id = values(category_id);

insert into category (category_id, division, category_code, category_name, created_at, updated_at)
values (19, 'DIVISION4', '01010102', '투피스', '2023-06-09T18:00', '2023-06-09T18:00') on duplicate key update category_id = values(category_id);

insert into category (category_id, division, category_code, category_name, created_at, updated_at)
values (20, 'DIVISION4', '01020101', '남성정장세트', '2023-06-09T18:00', '2023-06-09T18:00') on duplicate key update category_id = values(category_id);

insert into category (category_id, division, category_code, category_name, created_at, updated_at)
values (21, 'DIVISION4', '01020102', '남성장장재킷', '2023-06-09T18:00', '2023-06-09T18:00') on duplicate key update category_id = values(category_id);

insert into category (category_id, division, category_code, category_name, created_at, updated_at)
values (22, 'DIVISION4', '01030101', '셔츠/남방', '2023-06-09T18:00', '2023-06-09T18:00') on duplicate key update category_id = values(category_id);

insert into category (category_id, division, category_code, category_name, created_at, updated_at)
values (23, 'DIVISION4', '01030102', '점퍼', '2023-06-09T18:00', '2023-06-09T18:00') on duplicate key update category_id = values(category_id);

insert into category (category_id, division, category_code, category_name, created_at, updated_at)
values (24, 'DIVISION4', '01030103', '티셔츠', '2023-06-09T18:00', '2023-06-09T18:00') on duplicate key update category_id = values(category_id);

insert into category (category_id, division, category_code, category_name, created_at, updated_at)
values (25, 'DIVISION4', '01040101', '공용티셔츠', '2023-06-09T18:00', '2023-06-09T18:00') on duplicate key update category_id = values(category_id);

insert into category (category_id, division, category_code, category_name, created_at, updated_at)
values (26, 'DIVISION4', '01040102', '공용자캣', '2023-06-09T18:00', '2023-06-09T18:00') on duplicate key update category_id = values(category_id);

insert into category (category_id, division, category_code, category_name, created_at, updated_at)
values (27, 'DIVISION4', '01010201', '여성신발', '2023-06-09T18:00', '2023-06-09T18:00') on duplicate key update category_id = values(category_id);

insert into category (category_id, division, category_code, category_name, created_at, updated_at)
values (28, 'DIVISION4', '01020201', '남성신발', '2023-06-09T18:00', '2023-06-09T18:00') on duplicate key update category_id = values(category_id);

insert into category (category_id, division, category_code, category_name, created_at, updated_at)
values (29, 'DIVISION4', '02010101', '아이폰케이스', '2023-06-09T18:00', '2023-06-09T18:00') on duplicate key update category_id = values(category_id);

insert into category (category_id, division, category_code, category_name, created_at, updated_at)
values (30, 'DIVISION4', '02010102', '안드로이드케이스', '2023-06-09T18:00', '2023-06-09T18:00') on duplicate key update category_id = values(category_id);

insert into category (category_id, division, category_code, category_name, created_at, updated_at)
values (31, 'DIVISION4', '03010101', '바디클렌저', '2023-06-09T18:00', '2023-06-09T18:00') on duplicate key update category_id = values(category_id);

insert into category (category_id, division, category_code, category_name, created_at, updated_at)
values (32, 'DIVISION4', '03010102', '바디스크럽', '2023-06-09T18:00', '2023-06-09T18:00') on duplicate key update category_id = values(category_id);

insert into category (category_id, division, category_code, category_name, created_at, updated_at)
values (33, 'DIVISION4', '03010103', '풋케어', '2023-06-09T18:00', '2023-06-09T18:00') on duplicate key update category_id = values(category_id);