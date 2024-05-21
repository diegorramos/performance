import http from 'k6/http';
import { sleep } from 'k6';

export const options = {
  thresholds: {
    http_req_failed: [{ threshold: "rate<0.01", abortOnFail: true }],
    http_req_duration: ['p(99)<1000'],
  },
  scenarios: {
    // define scenarios
    breaking: {
      executor: "ramping-vus",
      stages: [
        { duration: "10s", target: 20 },
        { duration: "50s", target: 20 },
        { duration: "50s", target: 40 },
        { duration: "50s", target: 60 },
        { duration: "50s", target: 80 },
        { duration: "50s", target: 100 },
        { duration: "50s", target: 120 },
        { duration: "50s", target: 140 },
        //....
      ],
    },
  },
};

export default function () {
  let id = create()
  http.get('http://localhost:8080/orders/' + id);
  sleep(1);
}

export function create() {
  let id = Math.floor(Math.random() * 10000000000000001)
  let orderId = Math.floor(Math.random() * 10000000000000001)
  let data = { "id": id, "description": "amont", "orderId": orderId }

  let response = http.post('http://localhost:8080/orders', JSON.stringify(data), {
    headers: { 'Content-Type': 'application/json' },
  });

  return response.json().id;
}
