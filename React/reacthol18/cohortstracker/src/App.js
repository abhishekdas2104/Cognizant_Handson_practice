import React from 'react';
import CohortDetails from './CohortDetails';
import { CohortData } from './Cohort';
function App() {
  return (
    <div>
      <h2>Cohorts Details</h2>
      {CohortData.map(cohort => (
        <CohortDetails key={cohort.id} cohort={cohort} />
      ))}
    </div>
  );
}
export default App;
