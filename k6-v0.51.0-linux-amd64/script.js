import http from 'k6/http';
import { sleep } from 'k6';
import { check } from 'k6';


export const options = {
    thresholds: {
        http_req_duration: ["p(95)<1000"],
        http_req_duration: ["p(75)<500"],
        checks: ["rate>0.95"],
        http_req_failed: ["rate<0.1"],
    },
    noConnectionReuse: true,
    scenarios: {
        constant_scenario: {
            executor: 'constant-arrival-rate',
            duration: '1m',
            rate: 10,
            timeUnit: '1s',
            preAllocatedVUs: 50,
            maxVUs: 1000,
        }
    }
};

export default function () {
  let response = create()

  check(response, {
    "is status 202": (rs) => rs.status === 201,
  });

  let get = http.get('http://localhost:8080/orders/' + response.json().id);

  check(get, {
    "is status 200": (rs) => rs.status === 200,
  });
}

export function create() {
  let id = Math.floor(Math.random() * 10000000000000001)
  let orderId = Math.floor(Math.random() * 10000000000000001)
  let data = { "id": id, "description": "amont", "orderId": orderId }

  let response = http.post('http://localhost:8080/orders', JSON.stringify(data), {
    headers: { 'Content-Type': 'application/json' },
  });

  return response;
}
