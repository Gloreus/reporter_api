SELECT
    a as id
     ,'field1_' || a
     ,'field2_' || a
     ,'field3_' || a
     ,'field4_' || a
     ,'field5_' || a
     ,'field6_' || a
     ,'field7_' || a
     ,'field8_' || a
     ,'field9_' || a
     ,'field10_' || a
FROM generate_series(1, 1000) a;