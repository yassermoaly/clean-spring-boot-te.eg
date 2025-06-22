INSERT INTO Cities (NameEnglish, NameArabic, Visible)
SELECT 'Al Qalyubia', N'القليوبية', 1 WHERE NOT EXISTS (SELECT * FROM Cities WHERE NameEnglish = 'Al Qalyubia')