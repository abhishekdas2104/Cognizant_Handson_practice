import React from 'react';
function CohortDetails({ cohort }) {
  if (!cohort) return null;
  return (
    <div className="box">
      <h3 style={{ color: cohort.status === 'Ongoing' ? 'green' : 'blue' }}>
        {cohort.id} - {cohort.name}
      </h3>
      <dl>
        <dt>Started On</dt>
        <dd>{cohort.startedOn}</dd>
        <dt>Current Status</dt>
        <dd>{cohort.status}</dd>
        <dt>Coach</dt>
        <dd>{cohort.coach}</dd>
        <dt>Trainer</dt>
        <dd>{cohort.trainer}</dd>
      </dl>
    </div>
  );
}
export default CohortDetails;
