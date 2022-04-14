SELECT s.Name as Student,g.Grade,s.Marks
FROM Students s 
INNER JOIN Grades g ON s.Marks BETWEEN g.Min_Mark AND g.Max_Mark
WHERE g.Grade>=8
ORDER BY g.Grade DESC,s.Name ASC
UNION
SELECT NULL,g.Grade,s.Marks
FROM Students s 
INNER JOIN Grades g ON s.Marks BETWEEN g.Min_Mark AND g.Max_Mark
WHERE g.Grade<8
ORDER BY g.Grade DESC,s.Marks ASC