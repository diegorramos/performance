import http from 'k6/http';
import { sleep } from 'k6';

export const options = {
  // A number specifying the number of VUs to run concurrently.
  vus: 1000,
  // A string specifying the total duration of the test run.
  duration: '1m',

  thresholds: {
    http_req_failed: ['rate<0.01'], // http errors should be less than 1%
    http_req_duration: ['p(99)<1000'], // 99% of requests should be below 1s
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
