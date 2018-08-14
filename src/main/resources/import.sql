INSERT INTO CATEGORIES (ID, CATEGORY_NAME, CATEGORY_DESCRIPTION, APPROVAL_DATE) VALUES (1, 'secret', 'super secret stuff', '2018-08-10');
INSERT INTO CATEGORIES (ID, CATEGORY_NAME, CATEGORY_DESCRIPTION, APPROVAL_DATE) VALUES (2, 'resume', 'CVs of random people', '2018-08-10');
INSERT INTO CATEGORIES (ID, CATEGORY_NAME, CATEGORY_DESCRIPTION, APPROVAL_DATE) VALUES (3, 'tutorial', 'how to do stuff', '2018-08-10');
INSERT INTO CATEGORIES (ID, CATEGORY_NAME, CATEGORY_DESCRIPTION, APPROVAL_DATE) VALUES (4, 'movies', 'which movies to watch','2018-08-11' );
INSERT INTO CATEGORIES (ID, CATEGORY_NAME, CATEGORY_DESCRIPTION, APPROVAL_DATE) VALUES (5, 'series', 'how come series beat movies', '2018-08-12');
INSERT INTO CATEGORIES (ID, CATEGORY_NAME, CATEGORY_DESCRIPTION, APPROVAL_DATE) VALUES (6, 'cars', 'pictures of cars', '2018-08-12');
INSERT INTO CATEGORIES (ID, CATEGORY_NAME, CATEGORY_DESCRIPTION, APPROVAL_DATE) VALUES (7, 'random', 'random archive folder', '2018-08-13');

INSERT INTO FILES (ID, FILE_NAME, SAVED_PATH, IS_REMOVED, FILE_PERMISSIONS, FK_CATEGORY_ID) VALUES (10, 'Amazon Key', '/workspace-link/UploadedFiles/secret', true, 'OWNER_READ,OWNER_WRITE', 1)
INSERT INTO FILES (ID, FILE_NAME, SAVED_PATH, IS_REMOVED, FILE_PERMISSIONS, FK_CATEGORY_ID) VALUES (50, 'Battlestar Galactica', '/workspace-link/UploadedFiles/series', true, 'OTHERS_READ,OTHERS_WRITE,OTHERS_EXECUTE', 5);
INSERT INTO FILES (ID, FILE_NAME, SAVED_PATH, IS_REMOVED, FILE_PERMISSIONS, FK_CATEGORY_ID) VALUES (51, 'Community', '/workspace-link/UploadedFiles/series', true, 'OTHERS_READ,OTHERS_WRITE,OTHERS_EXECUTE', 5);
INSERT INTO FILES (ID, FILE_NAME, SAVED_PATH, IS_REMOVED, FILE_PERMISSIONS, FK_CATEGORY_ID) VALUES (40, 'The Road', '/workspace-link/UploadedFiles/movies', true, 'OTHERS_READ,OTHERS_WRITE,OTHERS_EXECUTE', 4);
INSERT INTO FILES (ID, FILE_NAME, SAVED_PATH, IS_REMOVED, FILE_PERMISSIONS, FK_CATEGORY_ID) VALUES (41, 'The Shawshank Redemption', '/workspace-link/UploadedFiles/movies', true, 'OTHERS_READ,OTHERS_WRITE,OTHERS_EXECUTE', 4);
INSERT INTO FILES (ID, FILE_NAME, SAVED_PATH, IS_REMOVED, FILE_PERMISSIONS, FK_CATEGORY_ID) VALUES (20, 'Some Random Guy', '/workspace-link/UploadedFiles/resume', true, 'OWNER_READ', 2);
INSERT INTO FILES (ID, FILE_NAME, SAVED_PATH, IS_REMOVED, FILE_PERMISSIONS, FK_CATEGORY_ID) VALUES (60, 'Mustang', '/workspace-link/UploadedFiles/cars', true, 'GROUP_READ,GROUP_WRITE', 6);
INSERT INTO FILES (ID, FILE_NAME, SAVED_PATH, IS_REMOVED, FILE_PERMISSIONS, FK_CATEGORY_ID) VALUES (61, 'Mercedes', '/workspace-link/UploadedFiles/cars', true, 'GROUP_READ,GROUP_WRITE', 6);
INSERT INTO FILES (ID, FILE_NAME, SAVED_PATH, IS_REMOVED, FILE_PERMISSIONS, FK_CATEGORY_ID) VALUES (30, 'Chicken Wings', '/workspace-link/UploadedFiles/tutorial', true, 'OWNER_READ,OWNER_WRITE,GROUP_READ,OTHERS_READ', 3);
INSERT INTO FILES (ID, FILE_NAME, SAVED_PATH, IS_REMOVED, FILE_PERMISSIONS, FK_CATEGORY_ID) VALUES (21, 'HR Specialist Trump', '/workspace-link/UploadedFiles/resume', true, 'OWNER_READ,OWNER_WRITE', 2);
INSERT INTO FILES (ID, FILE_NAME, SAVED_PATH, IS_REMOVED, FILE_PERMISSIONS, FK_CATEGORY_ID) VALUES (31, 'Amazon Web Services', '/workspace-link/UploadedFiles/tutorial', true, 'OWNER_READ,OWNER_WRITE,GROUP_READ', 3);


