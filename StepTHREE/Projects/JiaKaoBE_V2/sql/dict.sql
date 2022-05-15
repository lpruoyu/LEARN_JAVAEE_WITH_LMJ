# CREATE DATABASE jk CHARACTER SET utf8mb4;
# USE jk;

# CREATE TABLE user(
#     age TINYINT UNSIGNED,
#     ip INT UNSIGNED #只需要4个字节
# )

# INSERT INTO user VALUES(10, INET_ATON('255.255.255.255'))

# SELECT INET_NTOA(ip) FROM user

# create table jk.dict_type
# (
#     id    smallint unsigned auto_increment comment '主键'
#         primary key,
#     name  varchar(20)  default '' not null comment '名称',
#     value varchar(20)  default '' not null comment '值',
#     intro varchar(100) default '' not null comment '简介',
#     constraint dict_type_name_uindex
#         unique (name),
#     constraint dict_type_value_uindex
#         unique (value)
# )
#     comment '数据字典类型';
#
# create table jk.dict_item
# (
#     id      smallint unsigned auto_increment comment '主键'
#         primary key,
#     name    varchar(20)       default '' not null comment '名称',
#     value   varchar(20)       default '' not null comment '值',
#     type_id smallint unsigned            not null comment '类型id',
#     sn      smallint unsigned default 0  not null comment '排序序号：默认为0，值越大，越优先排列展示',
#     enabled tinyint unsigned  default 1  not null comment '是否启用：0，禁用；1，启用；默认为1',
#     constraint dict_item_name_type_id_uindex
#         unique (name, type_id),
#     constraint dict_item_value_type_id_uindex
#         unique (value, type_id)
# )
#     comment '数据字典条目';

-- ----------------------------
-- Records of dict_type
-- ----------------------------
# INSERT INTO `dict_type`(name, value, intro) VALUES ('职业', 'job', '一份工作');
# INSERT INTO `dict_type`(name, value, intro) VALUES ('哈哈12', 'haha12', '12');
# INSERT INTO `dict_type`(name, value, intro) VALUES ('哈哈13', 'haha13', '13');
# INSERT INTO `dict_type`(name, value, intro) VALUES ('哈哈14', 'haha14', '14');
# INSERT INTO `dict_type`(name, value, intro) VALUES ('哈哈15', 'haha15', '15');
# INSERT INTO `dict_type`(name, value, intro) VALUES ('哈哈16', 'haha16', '16');
# INSERT INTO `dict_type`(name, value, intro) VALUES ('哈哈17', 'haha17', '17');
# INSERT INTO `dict_type`(name, value, intro) VALUES ('哈哈18', 'haha18', '18');
# INSERT INTO `dict_type`(name, value, intro) VALUES ('哈哈19', 'haha19', '19');
# INSERT INTO `dict_type`(name, value, intro) VALUES ('哈哈20', 'haha20', '20');
# INSERT INTO `dict_type`(name, value, intro) VALUES ('哈哈21', 'haha21', '21');
# INSERT INTO `dict_type`(name, value, intro) VALUES ('哈哈22', 'haha22', '22');
# INSERT INTO `dict_type`(name, value, intro) VALUES ('哈哈23', 'haha23', '23');
# INSERT INTO `dict_type`(name, value, intro) VALUES ('哈哈24', 'haha24', '24');
# INSERT INTO `dict_type`(name, value, intro) VALUES ('哈哈25', 'haha25', '25');
# INSERT INTO `dict_type`(name, value, intro) VALUES ('哈哈26', 'haha26', '26');
# INSERT INTO `dict_type`(name, value, intro) VALUES ('哈哈27', 'haha27', '27');
# INSERT INTO `dict_type`(name, value, intro) VALUES ('哈哈28', 'haha28', '28');
# INSERT INTO `dict_type`(name, value, intro) VALUES ('哈哈29', 'haha29', '29');
# INSERT INTO `dict_type`(name, value, intro) VALUES ('哈哈30', 'haha30', '30');
# INSERT INTO `dict_type`(name, value, intro) VALUES ('哈哈31', 'haha31', '31');
# INSERT INTO `dict_type`(name, value, intro) VALUES ('哈哈32', 'haha32', '32');
# INSERT INTO `dict_type`(name, value, intro) VALUES ('哈哈33', 'haha33', '33');
# INSERT INTO `dict_type`(name, value, intro) VALUES ('哈哈34', 'haha34', '34');
# INSERT INTO `dict_type`(name, value, intro) VALUES ('哈哈35', 'haha35', '35');
# INSERT INTO `dict_type`(name, value, intro) VALUES ('哈哈36', 'haha36', '36');
# INSERT INTO `dict_type`(name, value, intro) VALUES ('哈哈37', 'haha37', '37');
# INSERT INTO `dict_type`(name, value, intro) VALUES ('哈哈38', 'haha38', '38');
# INSERT INTO `dict_type`(name, value, intro) VALUES ('哈哈39', 'haha39', '39');
# INSERT INTO `dict_type`(name, value, intro) VALUES ('哈哈40', 'haha40', '40');
# INSERT INTO `dict_type`(name, value, intro) VALUES ('哈哈41', 'haha41', '41');
# INSERT INTO `dict_type`(name, value, intro) VALUES ('哈哈42', 'haha42', '42');
# INSERT INTO `dict_type`(name, value, intro) VALUES ('哈哈43', 'haha43', '43');
# INSERT INTO `dict_type`(name, value, intro) VALUES ('哈哈44', 'haha44', '44');
# INSERT INTO `dict_type`(name, value, intro) VALUES ('哈哈45', 'haha45', '45');
# INSERT INTO `dict_type`(name, value, intro) VALUES ('哈哈46', 'haha46', '46');
# INSERT INTO `dict_type`(name, value, intro) VALUES ('哈哈47', 'haha47', '47');
# INSERT INTO `dict_type`(name, value, intro) VALUES ('哈哈48', 'haha48', '48');
# INSERT INTO `dict_type`(name, value, intro) VALUES ('哈哈49', 'haha49', '49');
# INSERT INTO `dict_type`(name, value, intro) VALUES ('哈哈50', 'haha50', '50');
# INSERT INTO `dict_type`(name, value, intro) VALUES ('哈哈51', 'haha51', '51');
# INSERT INTO `dict_type`(name, value, intro) VALUES ('哈哈52', 'haha52', '52');
# INSERT INTO `dict_type`(name, value, intro) VALUES ('哈哈53', 'haha53', '53');
# INSERT INTO `dict_type`(name, value, intro) VALUES ('哈哈54', 'haha54', '54');
# INSERT INTO `dict_type`(name, value, intro) VALUES ('哈哈55', 'haha55', '55');
# INSERT INTO `dict_type`(name, value, intro) VALUES ('哈哈56', 'haha56', '56');
# INSERT INTO `dict_type`(name, value, intro) VALUES ('哈哈57', 'haha57', '57');
# INSERT INTO `dict_type`(name, value, intro) VALUES ('哈哈58', 'haha58', '58');
# INSERT INTO `dict_type`(name, value, intro) VALUES ('哈哈59', 'haha59', '59');
# INSERT INTO `dict_type`(name, value, intro) VALUES ('哈哈60', 'haha60', '60');
# INSERT INTO `dict_type`(name, value, intro) VALUES ('哈哈61', 'haha61', '61');
# INSERT INTO `dict_type`(name, value, intro) VALUES ('哈哈62', 'haha62', '62');
# INSERT INTO `dict_type`(name, value, intro) VALUES ('哈哈63', 'haha63', '63');
# INSERT INTO `dict_type`(name, value, intro) VALUES ('哈哈64', 'haha64', '64');
# INSERT INTO `dict_type`(name, value, intro) VALUES ('哈哈65', 'haha65', '65');
# INSERT INTO `dict_type`(name, value, intro) VALUES ('哈哈66', 'haha66', '66');
# INSERT INTO `dict_type`(name, value, intro) VALUES ('哈哈67', 'haha67', '67');
# INSERT INTO `dict_type`(name, value, intro) VALUES ('哈哈68', '756567657', '68');
# INSERT INTO `dict_type`(name, value, intro) VALUES ('哈哈69', 'haha69', '69');
# INSERT INTO `dict_type`(name, value, intro) VALUES ('哈哈70', 'haha70', '70');
# INSERT INTO `dict_type`(name, value, intro) VALUES ('哈哈71', 'haha71', '71');
# INSERT INTO `dict_type`(name, value, intro) VALUES ('哈哈72', 'haha72', '72');
# INSERT INTO `dict_type`(name, value, intro) VALUES ('哈哈73', 'haha73', '73');
# INSERT INTO `dict_type`(name, value, intro) VALUES ('哈哈74', 'haha74', '74');
# INSERT INTO `dict_type`(name, value, intro) VALUES ('哈哈75', 'haha75', '75');
# INSERT INTO `dict_type`(name, value, intro) VALUES ('哈哈76', 'haha76', '76');
# INSERT INTO `dict_type`(name, value, intro) VALUES ('哈哈77', 'haha77', '77');
# INSERT INTO `dict_type`(name, value, intro) VALUES ('哈哈83', 'haha83', '83');
# INSERT INTO `dict_type`(name, value, intro) VALUES ('哈哈84', 'haha84', '84');
# INSERT INTO `dict_type`(name, value, intro) VALUES ('哈哈85', 'haha85', '85');
# INSERT INTO `dict_type`(name, value, intro) VALUES ('哈哈86', 'haha86', '86');
# INSERT INTO `dict_type`(name, value, intro) VALUES ('哈哈87', 'haha87', '87');
# INSERT INTO `dict_type`(name, value, intro) VALUES ('哈哈88', 'haha88', '88');
# INSERT INTO `dict_type`(name, value, intro) VALUES ('哈哈89', 'haha89', '89');
# INSERT INTO `dict_type`(name, value, intro) VALUES ('哈哈90', 'haha90', '90');
# INSERT INTO `dict_type`(name, value, intro) VALUES ('哈哈91', 'haha91', '91');
# INSERT INTO `dict_type`(name, value, intro) VALUES ('哈哈92', 'haha92', '92');
# INSERT INTO `dict_type`(name, value, intro) VALUES ('哈哈93', 'haha93', '93');
# INSERT INTO `dict_type`(name, value, intro) VALUES ('哈哈94', 'haha94', '94');
# INSERT INTO `dict_type`(name, value, intro) VALUES ('哈哈95', 'haha95', '95');
# INSERT INTO `dict_type`(name, value, intro) VALUES ('哈哈96', 'haha96', '96');
# INSERT INTO `dict_type`(name, value, intro) VALUES ('哈哈97', 'haha97', '97');
# INSERT INTO `dict_type`(name, value, intro) VALUES ('哈哈98', 'haha98', '98');
# INSERT INTO `dict_type`(name, value, intro) VALUES ('哈哈99', 'haha99', '99');
# INSERT INTO `dict_type`(name, value, intro) VALUES ('654546', '765768768', '789789789');
# INSERT INTO `dict_type`(name, value, intro) VALUES ('123', '123', '123');
# INSERT INTO `dict_type`(name, value, intro) VALUES ('科2科3课程类型', 'course_type', '科2科3课程类型科2科3课程类型科2科3课程类型科2科3课程类型');

-- ----------------------------
-- Records of dict_item
-- ----------------------------
# INSERT INTO `dict_item`(name,value,type_id,sn,enabled) VALUES ('程序员', 'coder', 8, 1, 1);
# INSERT INTO `dict_item`(name,value,type_id,sn,enabled) VALUES ('教师', 'teacher', 12, 0, 1);
# INSERT INTO `dict_item`(name,value,type_id,sn,enabled) VALUES ('司机', 'driver', 6, 1, 1);
# INSERT INTO `dict_item`(name,value,type_id,sn,enabled) VALUES ('学员', 'student', 6, 0, 0);
# INSERT INTO `dict_item`(name,value,type_id,sn,enabled) VALUES ('666', '666', 1, 0, 0);
# INSERT INTO `dict_item`(name,value,type_id,sn,enabled) VALUES ('课程合集', 'course0', 2, 0, 1);
# INSERT INTO `dict_item`(name,value,type_id,sn,enabled) VALUES ('科目2', 'km2', 2, 0, 0);
# INSERT INTO `dict_item`(name,value,type_id,sn,enabled) VALUES ('科目3', 'km3', 2, 0, 0);