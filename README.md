# performance

### Results:

#### Blocking results:

```bash
    execution: local
        script: script.js
        output: -

     scenarios: (100.00%) 1 scenario, 140 max VUs, 6m30s max duration (incl. graceful stop):
              * breaking: Up to 140 looping VUs for 6m0s over 8 stages (gracefulRampDown: 30s, gracefulStop: 30s)

     data_received..................: 10 MB  28 kB/s
     data_sent......................: 7.8 MB 22 kB/s
     http_req_blocked...............: avg=11.23µs  min=650ns    med=6.28µs   max=14.17ms  p(90)=7.87µs   p(95)=8.69µs  
     http_req_connecting............: avg=3.67µs   min=0s       med=0s       max=14.12ms  p(90)=0s       p(95)=0s      
   ✓ http_req_duration..............: avg=2.98ms   min=230.58µs med=2.68ms   max=171.96ms p(90)=4.92ms   p(95)=5.74ms  
       { expected_response:true }...: avg=2.98ms   min=230.58µs med=2.68ms   max=171.96ms p(90)=4.92ms   p(95)=5.74ms  
   ✓ http_req_failed................: 0.00%  ✓ 0         ✗ 49672
     http_req_receiving.............: avg=137.38µs min=8.13µs   med=122.09µs max=18.62ms  p(90)=198.72µs p(95)=320.67µs
     http_req_sending...............: avg=35.07µs  min=3.41µs   med=34.08µs  max=1.31ms   p(90)=49.54µs  p(95)=54.24µs 
     http_req_tls_handshaking.......: avg=0s       min=0s       med=0s       max=0s       p(90)=0s       p(95)=0s      
     http_req_waiting...............: avg=2.8ms    min=204.66µs med=2.51ms   max=170.38ms p(90)=4.72ms   p(95)=5.51ms  
     http_reqs......................: 49672  137.59304/s
     iteration_duration.............: avg=1s       min=1s       med=1s       max=1.18s    p(90)=1s       p(95)=1.01s   
     iterations.....................: 24836  68.79652/s
     vus............................: 8      min=2       max=139
     vus_max........................: 140    min=140     max=140


running (6m01.0s), 000/140 VUs, 24836 complete and 0 interrupted iterations
breaking ✓ [======================================] 000/140 VUs  6m0s
```

#### Non Blocking results:

```bash
    execution: local
        script: script.js
        output: -

     scenarios: (100.00%) 1 scenario, 140 max VUs, 6m30s max duration (incl. graceful stop):
              * breaking: Up to 140 looping VUs for 6m0s over 8 stages (gracefulRampDown: 30s, gracefulStop: 30s)

     data_received..................: 7.4 MB 21 kB/s
     data_sent......................: 7.8 MB 22 kB/s
     http_req_blocked...............: avg=8.61µs  min=701ns    med=6.45µs  max=35.85ms  p(90)=7.91µs   p(95)=8.49µs  
     http_req_connecting............: avg=1.9µs   min=0s       med=0s      max=35.71ms  p(90)=0s       p(95)=0s      
   ✓ http_req_duration..............: avg=3.01ms  min=283.7µs  med=2.68ms  max=333.91ms p(90)=4.76ms   p(95)=5.84ms  
       { expected_response:true }...: avg=3.01ms  min=283.7µs  med=2.68ms  max=333.91ms p(90)=4.76ms   p(95)=5.84ms  
   ✓ http_req_failed................: 0.00%  ✓ 0          ✗ 49690
     http_req_receiving.............: avg=78.51µs min=7.26µs   med=80.13µs max=1.75ms   p(90)=100.41µs p(95)=110.55µs
     http_req_sending...............: avg=35.77µs min=3.65µs   med=35.07µs max=5.8ms    p(90)=49.61µs  p(95)=53.09µs 
     http_req_tls_handshaking.......: avg=0s      min=0s       med=0s      max=0s       p(90)=0s       p(95)=0s      
     http_req_waiting...............: avg=2.89ms  min=269.53µs med=2.55ms  max=333.79ms p(90)=4.63ms   p(95)=5.7ms   
     http_reqs......................: 49690  137.643656/s
     iteration_duration.............: avg=1s      min=1s       med=1s      max=1.36s    p(90)=1s       p(95)=1.01s   
     iterations.....................: 24845  68.821828/s
     vus............................: 4      min=2        max=139
     vus_max........................: 140    min=140      max=140


running (6m01.0s), 000/140 VUs, 24845 complete and 0 interrupted iterations
breaking ✓ [======================================] 000/140 VUs  6m0s

```