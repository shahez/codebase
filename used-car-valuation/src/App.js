import React, { useState, useEffect } from 'react';
import { Container, Typography, TextField, Switch, Grid, Slider, Button } from '@material-ui/core';

function App() {
  const [showroomPrice, setShowroomPrice] = useState(0);
  const [age, setAge] = useState(0);
  const [mileage, setMileage] = useState(0);
  const [wellMaintainedHistory, setWellMaintainedHistory] = useState(false);
  const [numOwners, setNumOwners] = useState(1);
  const [warranty, setWarranty] = useState(false);
  const [interiors, setInteriors] = useState(2);
  const [engine, setEngine] = useState(2);
  const [scratches, setScratches] = useState(2);

  const marks = [
    {
      value: 1,
      label: 'Fair',
    },
    {
      value: 2,
      label: 'Good',
    },
    {
      value: 3,
      label: 'Very Good',
    },
    {
      value: 4,
      label: 'Excellent',
    },
  ];

  useEffect(() => {
    handleEstimateClick();
  }, [showroomPrice, age, mileage, wellMaintainedHistory, warranty, interiors, scratches, engine]);
  const handleEstimateClick = () => {
    // Your estimation logic here
    
    const estimatedPrice = calculateEstimatedPrice();
    console.log(`Estimated Price: ₹${estimatedPrice.min} - ₹${estimatedPrice.max}`);
    const resultElement = document.getElementById('result');
    resultElement.innerHTML = `₹${estimatedPrice.min} - ₹${estimatedPrice.max}`;
  }

  function calculateEstimatedPrice() {
    let price = showroomPrice; // Initial showroom price. Should be from DB.
    // Depreciation and Appreciation Factors
    const factors = {
        mileageLessThan50k: -50,  // Depreciation for less than 15k mileage
        wellMaintainedHistory: 5, // Appreciation for well-maintained history
        numOwners: -4,        // Depreciation for number of owners
        warranty: 5           // Appreciation for warranty
    };

      // Depreciation percentages based on slider values
    const depreciationPercentages = {
      1: 5,  // Fair - 5%
      2: 3,  // Good - 3%
      3: 2,  // Very Good - 2%
      4: 0   // Excellent - 0%
    };

    // Age depreciation criteria
    if (age <= 0.5) {
        price *= (1 + -5 / 100);
    } else if (age <= 1) {
        price *= (1 + -10 / 100);
    } else if (age <= 2) {
        price *= (1 + -20 / 100);
    } else if (age <= 3) {
        price *= (1 + -30 / 100);
    } else if (age <= 4) {
        price *= (1 + -40 / 100);
    } else {
        price *= (1 + -50 / 100);
    }
    if (mileage > 50000) {
        price *= (1 + factors.mileageLessThan50k / 100); // Apply mileage depreciation
    }
    else{
        const mileageDepreciation = Math.floor(mileage / 10000) * 10;
        price *= (1 + -mileageDepreciation / 100);
    }
    if (scratches) {
        // Apply depreciation based on defects
        const scratchesDepreciation = depreciationPercentages[scratches];
        price *= (1 - scratchesDepreciation / 100); // Apply minor scratches depreciation
    }

    if (numOwners > 1) {
        price *= (1 + factors.numOwners * numOwners / 100); // Apply 3 owners depreciation
    }
    if (interiors) {
      // Apply depreciation based on interiors condition
    const interiorsDepreciation = depreciationPercentages[interiors];
    price *= (1 - interiorsDepreciation / 100); // Apply well-maintained interiors appreciation
    }
    if (engine) {
        // Apply depreciation based on interiors condition
        const engineDepreciation = depreciationPercentages[engine];
        price *= (1 - engineDepreciation / 100); // Apply well-maintained interiors appreciation
      }
    if (wellMaintainedHistory){
        price *= (1 + factors.wellMaintainedHistory / 100); // Apply well-maintained history appreciation
    }
    if (warranty) {
        price *= (1 + factors.warranty / 100); // Apply warranty appreciation
    }
    const maxPrice = price * 1.10
    return {'min': price.toFixed(0), 'max': maxPrice.toFixed(0)}; // Return the estimated price
}

  return (
    <Container>
      <Typography variant="h4" align="center">Used Car Valuation React APP</Typography>
      <TextField
        label="Enter vehicle price (in ₹)"
        type="number"
        fullWidth
        value={showroomPrice}
        onChange={(e) => setShowroomPrice(e.target.value)}
      />
      <TextField
        label="Enter age of the car (in years)"
        type="number"
        fullWidth
        value={age}
        onChange={(e) => setAge(e.target.value)}
      />
      <TextField
        label="Enter mileage (in kilometers)"
        type="number"
        fullWidth
        value={mileage}
        onChange={(e) => setMileage(e.target.value)}
      />
      <Grid container alignItems="center">
        <Grid item>
          <Typography variant="body1">Well Maintained Service History</Typography>
        </Grid>
        <Grid item>
          <Switch
            checked={wellMaintainedHistory}
            onChange={() => setWellMaintainedHistory(!wellMaintainedHistory)}
          />
        </Grid>
      </Grid>
      <TextField
        label="Enter number of owners"
        type="number"
        fullWidth
        value={numOwners}
        onChange={(e) => setNumOwners(e.target.value)}
      />
      <Grid container alignItems="center">
        <Grid item>
          <Typography variant="body1">Warranty</Typography>
        </Grid>
        <Grid item>
          <Switch
            checked={warranty}
            onChange={() => setWarranty(!warranty)}
          />
        </Grid>
      </Grid>
      <Typography variant="body1">Interiors Condition: {interiors}</Typography>
      <Slider
        value={interiors}
        min={1}
        max={4}
        step={1}
        marks={marks}
        onChange={(e, value) => setInteriors(value)}
        valueLabelDisplay="auto"
      />
      <Typography variant="body1">Engine Condition: {engine}</Typography>
      <Slider
        value={engine}
        min={1}
        max={4}
        step={1}
        marks={marks}
        onChange={(e, value) => setEngine(value)}
        valueLabelDisplay="auto"
      />
      <Typography variant="body1">Exterior Condition: {scratches}</Typography>
      <Slider
        value={scratches}
        min={1}
        max={4}
        step={1}
        marks={marks}
        onChange={(e, value) => setScratches(value)}
        valueLabelDisplay="auto"
      />
      <Button
        variant="contained"
        color="primary"
        onClick={handleEstimateClick}
      >
        Estimate Price
      </Button>
      <div id="resultContainer" style={{ marginTop: '20px' }}>
      <Typography variant="h6">Estimated Price Range:</Typography>
      <Typography variant="body1" id="result"></Typography>
    </div>
    </Container>
  );
}

export default App;