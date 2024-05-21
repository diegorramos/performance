# performance

### Results:

#### Blocking results:

```bash
    execution: local
        script: script.js
        output: -

     scenarios: (100.00%) 1 scenario, 1000 max VUs, 1m30s max duration (incl. graceful stop):
              * constant_scenario: 10.00 iterations/s for 1m0s (maxVUs: 50-1000, gracefulStop: 30s)


     ✗ is status 202
      ↳  0% — ✓ 0 / ✗ 600
     ✓ is status 200

   ✗ checks.........................: 50.00% ✓ 600       ✗ 600 
     data_received..................: 264 kB 4.4 kB/s
     data_sent......................: 211 kB 3.5 kB/s
     http_req_blocked...............: avg=337.87µs min=73.56µs med=400.46µs max=3.16ms   p(90)=461.67µs p(95)=474.57µs
     http_req_connecting............: avg=225.16µs min=44.41µs med=263.03µs max=3.06ms   p(90)=311.84µs p(95)=321.6µs 
   ✓ http_req_duration..............: avg=6.8ms    min=1.43ms  med=6.57ms   max=159.96ms p(90)=10.63ms  p(95)=11.93ms 
       { expected_response:true }...: avg=6.8ms    min=1.43ms  med=6.57ms   max=159.96ms p(90)=10.63ms  p(95)=11.93ms 
   ✓ http_req_failed................: 0.00%  ✓ 0         ✗ 1200
     http_req_receiving.............: avg=599.35µs min=71.58µs med=640.61µs max=1.85ms   p(90)=1.01ms   p(95)=1.17ms  
     http_req_sending...............: avg=98.35µs  min=15.15µs med=101.27µs max=248.49µs p(90)=154.47µs p(95)=173.6µs 
     http_req_tls_handshaking.......: avg=0s       min=0s      med=0s       max=0s       p(90)=0s       p(95)=0s      
     http_req_waiting...............: avg=6.1ms    min=1.19ms  med=5.73ms   max=158.32ms p(90)=9.63ms   p(95)=10.77ms 
     http_reqs......................: 1200   19.999716/s
     iteration_duration.............: avg=14.83ms  min=4.29ms  med=15.42ms  max=172.36ms p(90)=21.58ms  p(95)=24.19ms 
     iterations.....................: 600    9.999858/s
     vus............................: 0      min=0       max=0 
     vus_max........................: 50     min=50      max=50


running (1m00.0s), 0000/0050 VUs, 600 complete and 0 interrupted iterations
constant_scenario ✓ [======================================] 0000/0050 VUs  1m0s  10.00 iters/s
ERRO[0061] thresholds on metrics 'checks' have been crossed
```

#### Non Blocking results:

```bash
    execution: local
        script: script.js
        output: -

     scenarios: (100.00%) 1 scenario, 1000 max VUs, 1m30s max duration (incl. graceful stop):
              * constant_scenario: 10.00 iterations/s for 1m0s (maxVUs: 50-1000, gracefulStop: 30s)


     ✓ is status 202
     ✓ is status 200

   ✓ checks.........................: 100.00% ✓ 1202      ✗ 0   
     data_received..................: 202 kB  3.4 kB/s
     data_sent......................: 211 kB  3.5 kB/s
     http_req_blocked...............: avg=363.04µs min=79.67µs med=404.96µs max=5.11ms   p(90)=448.53µs p(95)=458.33µs
     http_req_connecting............: avg=240.25µs min=46.99µs med=265.6µs  max=4.32ms   p(90)=297.29µs p(95)=306.77µs
   ✓ http_req_duration..............: avg=7.47ms   min=1.65ms  med=6.82ms   max=351.3ms  p(90)=10.46ms  p(95)=11.88ms 
       { expected_response:true }...: avg=7.47ms   min=1.65ms  med=6.82ms   max=351.3ms  p(90)=10.46ms  p(95)=11.88ms 
   ✓ http_req_failed................: 0.00%   ✓ 0         ✗ 1202
     http_req_receiving.............: avg=126.91µs min=40.02µs med=137.93µs max=808.35µs p(90)=185.02µs p(95)=198.78µs
     http_req_sending...............: avg=110.96µs min=23.38µs med=113.84µs max=218µs    p(90)=162.97µs p(95)=176.6µs 
     http_req_tls_handshaking.......: avg=0s       min=0s      med=0s       max=0s       p(90)=0s       p(95)=0s      
     http_req_waiting...............: avg=7.23ms   min=1.56ms  med=6.56ms   max=351.16ms p(90)=10.19ms  p(95)=11.56ms 
     http_reqs......................: 1202    20.028763/s
     iteration_duration.............: avg=16.24ms  min=5.45ms  med=14.91ms  max=373.68ms p(90)=22.24ms  p(95)=25.34ms 
     iterations.....................: 601     10.014381/s
     vus............................: 0       min=0       max=0 
     vus_max........................: 50      min=50      max=50


running (1m00.0s), 0000/0050 VUs, 601 complete and 0 interrupted iterations
constant_scenario ✓ [======================================] 0000/0050 VUs  1m0s  10.00 iters/s
```