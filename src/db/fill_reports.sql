insert into reports (name, description, group_id)
SELECT
    'report_' || a
     , 'Отчет номер '|| a || ' из группы '|| a/10
     ,  a / 10
FROM generate_series(1, 1000) a;

commit;

