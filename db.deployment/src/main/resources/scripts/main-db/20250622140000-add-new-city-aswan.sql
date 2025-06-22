INSERT INTO Cities (NameEnglish, NameArabic, Visible)
SELECT 'Aswan', N'اسوان', 1 WHERE NOT EXISTS (SELECT * FROM Cities WHERE NameEnglish = 'Aswan')