<?php

namespace app\models;

use Yii;

/**
 * This is the model class for table "Bestellpositionen".
 *
 * @property int $Bestellnummer
 * @property string $ProduktID
 * @property int $Menge
 *
 * @property Bestellungen $bestellnummer
 * @property Produkte $produkt
 */
class Bestellpositionen extends \yii\db\ActiveRecord
{


    /**
     * {@inheritdoc}
     */
    public static function tableName()
    {
        return 'Bestellpositionen';
    }

    /**
     * {@inheritdoc}
     */
    public function rules()
    {
        return [
            [['Bestellnummer', 'ProduktID', 'Menge'], 'required'],
            [['Bestellnummer', 'Menge'], 'integer'],
            [['ProduktID'], 'string', 'max' => 10],
            [['Bestellnummer', 'ProduktID'], 'unique', 'targetAttribute' => ['Bestellnummer', 'ProduktID']],
            [['Bestellnummer'], 'exist', 'skipOnError' => true, 'targetClass' => Bestellungen::class, 'targetAttribute' => ['Bestellnummer' => 'Bestellnummer']],
            [['ProduktID'], 'exist', 'skipOnError' => true, 'targetClass' => Produkte::class, 'targetAttribute' => ['ProduktID' => 'ProduktID']],
        ];
    }

    /**
     * {@inheritdoc}
     */
    public function attributeLabels()
    {
        return [
            'Bestellnummer' => Yii::t('app', 'Bestellnummer'),
            'ProduktID' => Yii::t('app', 'Produkt ID'),
            'Menge' => Yii::t('app', 'Menge'),
        ];
    }

    /**
     * Gets query for [[Bestellnummer]].
     *
     * @return \yii\db\ActiveQuery|BestellungenQuery
     */
    public function getBestellnummer()
    {
        return $this->hasOne(Bestellungen::class, ['Bestellnummer' => 'Bestellnummer']);
    }

    /**
     * Gets query for [[Produkt]].
     *
     * @return \yii\db\ActiveQuery|ProdukteQuery
     */
    public function getProdukt()
    {
        return $this->hasOne(Produkte::class, ['ProduktID' => 'ProduktID']);
    }

    /**
     * {@inheritdoc}
     * @return BestellpositionenQuery the active query used by this AR class.
     */
    public static function find()
    {
        return new BestellpositionenQuery(get_called_class());
    }

}
