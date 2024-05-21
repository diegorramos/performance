# performance

### Results:

#### Blocking results:

```bash
    execution: local
        script: script.js
        output: -

     scenarios: (100.00%) 1 scenario, 1000 max VUs, 1m30s max duration (incl. graceful stop):
              * default: 1000 looping VUs for 1m0s (gracefulStop: 30s)

     data_received..................: 23 MB  378 kB/s
     data_sent......................: 18 MB  295 kB/s
     http_req_blocked...............: avg=2.29ms   min=561ns    med=2.25µs max=1.08s   p(90)=6.73µs   p(95)=7.45µs  
     http_req_connecting............: avg=2.28ms   min=0s       med=0s     max=1.08s   p(90)=0s       p(95)=0s      
   ✓ http_req_duration..............: avg=26.21ms  min=211.83µs med=3.82ms max=1.24s   p(90)=66.86ms  p(95)=99.64ms 
       { expected_response:true }...: avg=26.21ms  min=211.83µs med=3.82ms max=1.24s   p(90)=66.86ms  p(95)=99.64ms 
   ✓ http_req_failed................: 0.00%  ✓ 0          ✗ 114618
     http_req_receiving.............: avg=126.72µs min=7.66µs   med=48.2µs max=22.56ms p(90)=216.98µs p(95)=435.74µs
     http_req_sending...............: avg=50.35µs  min=3.1µs    med=11.4µs max=47.09ms p(90)=40.43µs  p(95)=62.63µs 
     http_req_tls_handshaking.......: avg=0s       min=0s       med=0s     max=0s      p(90)=0s       p(95)=0s      
     http_req_waiting...............: avg=26.04ms  min=186.59µs med=3.65ms max=1.24s   p(90)=66.65ms  p(95)=99.45ms 
     http_reqs......................: 114618 1878.65948/s
     iteration_duration.............: avg=1.05s    min=1s       med=1s     max=2.49s   p(90)=1.12s    p(95)=1.16s   
     iterations.....................: 57309  939.32974/s
     vus............................: 77     min=77       max=1000
     vus_max........................: 1000   min=1000     max=1000


running (1m01.0s), 0000/1000 VUs, 57309 complete and 0 interrupted iterations
default ✓ [======================================] 1000 VUs  1m0s
```

#### Non Blocking results:

```bash
      execution: local
        script: script.js
        output: -

     scenarios: (100.00%) 1 scenario, 1000 max VUs, 1m30s max duration (incl. graceful stop):
              * default: 1000 looping VUs for 1m0s (gracefulStop: 30s)

     data_received..................: 17 MB  274 kB/s
     data_sent......................: 18 MB  288 kB/s
     http_req_blocked...............: avg=143.66µs min=548ns    med=2.47µs  max=103.41ms p(90)=6.69µs  p(95)=7.37µs  
     http_req_connecting............: avg=130.04µs min=0s       med=0s      max=86.99ms  p(90)=0s      p(95)=0s      
   ✓ http_req_duration..............: avg=40.23ms  min=265µs    med=3.96ms  max=1.35s    p(90)=88.3ms  p(95)=124.15ms
       { expected_response:true }...: avg=40.23ms  min=265µs    med=3.96ms  max=1.35s    p(90)=88.3ms  p(95)=124.15ms
   ✓ http_req_failed................: 0.00%  ✓ 0           ✗ 111900
     http_req_receiving.............: avg=50.53µs  min=6.51µs   med=27.89µs max=34.71ms  p(90)=83.53µs p(95)=102.3µs 
     http_req_sending...............: avg=125.89µs min=3.14µs   med=12.51µs max=60.28ms  p(90)=40.57µs p(95)=70.47µs 
     http_req_tls_handshaking.......: avg=0s       min=0s       med=0s      max=0s       p(90)=0s      p(95)=0s      
     http_req_waiting...............: avg=40.06ms  min=245.62µs med=3.86ms  max=1.35s    p(90)=87.83ms p(95)=123.56ms
     http_reqs......................: 111900 1834.356966/s
     iteration_duration.............: avg=1.08s    min=1s       med=1s      max=2.92s    p(90)=1.17s   p(95)=1.21s   
     iterations.....................: 55950  917.178483/s
     vus............................: 4      min=4         max=1000
     vus_max........................: 1000   min=1000      max=1000


running (1m01.0s), 0000/1000 VUs, 55950 complete and 0 interrupted iterations
default ✓ [======================================] 1000 VUs  1m0s

```